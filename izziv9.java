import java.util.ArrayList;
import java.util.Scanner;

public class izziv9 {
    
    public static class Global{
        public static Network net;
        public static int[][] matrika;
    }

    public static class Node {
        int id;
        // marks for the algorithm
        // ------------------------------------
        boolean marked = false;
        Edge augmEdge = null; // the edge over which we brought the flow increase
        int incFlow = -1; // -1 means a potentially infinite flow
        // ------------------------------------
        ArrayList<Edge> inEdges;
        ArrayList<Edge> outEdges;

        public Node(int i) {
            id = i;
            inEdges = new ArrayList<Edge>();
            outEdges = new ArrayList<Edge>();
        }
    }

    public static class Edge {
        int startID;
        int endID;
        int capacity;
        int currFlow;

        public Edge(int fromNode, int toNode, int capacity2) {
            startID = fromNode;
            endID = toNode;
            capacity = capacity2;
            currFlow = 0;
        }
    }

    public static class Network {
        Node[] nodes;

        /**
         * Create a new network with n nodes (0..n-1).
         * 
         * @param n the size of the network.
         */
        public Network(int n) {
            nodes = new Node[n];
            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = new Node(i);
            }
        }

        /**
         * Add a connection to the network, with all the corresponding in and out edges.
         * 
         * @param fromNode
         * @param toNode
         * @param capacity
         */
        public void addConnection(int fromNode, int toNode, int capacity) {
            Edge e = new Edge(fromNode, toNode, capacity);
            nodes[fromNode].outEdges.add(e);
            nodes[toNode].inEdges.add(e);
        }

        /**
         * Reset all the marks of the algorithm, before the start of a new iteration.
         */
        public void resetMarks() {
            for (int i = 0; i < nodes.length; i++) {
                nodes[i].marked = false;
                nodes[i].augmEdge = null;
                nodes[i].incFlow = -1;
            }
        }
    }

    public static void adjustflow(Network net,String[] pot,int flow){
        System.out.print(flow+": ");
        for(int i=0;i<pot.length-1;i++){
            for(int j=0;j<Global.net.nodes[Integer.parseInt(pot[i])].inEdges.size();j++){
                if(Global.net.nodes[Integer.parseInt(pot[i])].inEdges.get(j).startID==Integer.parseInt(pot[i+1])){
                    Global.net.nodes[Integer.parseInt(pot[i])].inEdges.get(j).currFlow=Global.net.nodes[Integer.parseInt(pot[i])].inEdges.get(j).currFlow-flow;
                    System.out.print(Integer.parseInt(pot[i])+"+  ");
                    break;
                }
            }
            for(int j=0;j<Global.net.nodes[Integer.parseInt(pot[i])].outEdges.size();j++){
                if(Global.net.nodes[Integer.parseInt(pot[i])].outEdges.get(j).endID==Integer.parseInt(pot[i+1])){
                    Global.net.nodes[Integer.parseInt(pot[i])].outEdges.get(j).currFlow=Global.net.nodes[Integer.parseInt(pot[i])].outEdges.get(j).currFlow-flow;
                    System.out.print(Integer.parseInt(pot[i])+"-  ");
                    break;
                }
            }
        }
        System.out.print("0");
        System.out.println();
    }

    public static void isci(Network net, int currnode, int innode, int inflow, String pot, int zadnja,boolean[] obiskani) {
        if (inflow == 0) {
            return;
        }
        if (currnode == zadnja) {
            pot=Integer.toString(zadnja)+" "+pot;
            adjustflow(Global.net,pot.split(" "),inflow);
            //System.out.println(inflow + ": "+zadnja+"+  " + pot);
            return;
        }

        for (int i = 0; i < Global.net.nodes[currnode].outEdges.size(); i++) {
            if (Global.net.nodes[currnode].outEdges.get(i).endID != innode&&!obiskani[Global.net.nodes[currnode].outEdges.get(i).endID]) {
                int cFlow = Global.net.nodes[currnode].outEdges.get(i).currFlow;
                int capa = Global.net.nodes[currnode].outEdges.get(i).capacity;
                if (cFlow < capa) {
                    int razl = capa - cFlow;
                    if (inflow <= razl) {
                        //net.nodes[currnode].outEdges.get(i).currFlow = net.nodes[currnode].outEdges.get(i).currFlow + inflow;
                        if (currnode != 0) {
                            pot = currnode + " " + pot;
                        } else {
                            pot = "0";
                        }
                        obiskani[currnode]=true;
                        System.out.println("inflow: "+inflow+" pri currnode: "+currnode+" prostor: "+Global.net.nodes[currnode].outEdges.get(i).capacity);
                        isci(Global.net, Global.net.nodes[currnode].outEdges.get(i).endID, currnode, inflow, pot, zadnja,obiskani);
                        obiskani[currnode]=false;
                        return;
                    } else {
                        //net.nodes[currnode].outEdges.get(i).currFlow = net.nodes[currnode].outEdges.get(i).capacity;
                        if (currnode != 0) {
                            pot = currnode + " " + pot;
                        } else {
                            pot = "0";
                        }
                        obiskani[currnode]=true;
                        System.out.println("inflow: "+inflow+" pri currnode: "+currnode+" prostor: "+Global.net.nodes[currnode].outEdges.get(i).capacity);
                        isci(Global.net, Global.net.nodes[currnode].outEdges.get(i).endID, currnode, razl, pot, zadnja,obiskani);
                        obiskani[currnode]=false;
                        return;
                    }
                }
            }
        }
        for (int i = 0; i < Global.net.nodes[currnode].inEdges.size(); i++) {
            if (Global.net.nodes[currnode].inEdges.get(i).startID != innode&&!obiskani[Global.net.nodes[currnode].inEdges.get(i).startID]) {
                int cFlow = Global.net.nodes[currnode].inEdges.get(i).currFlow;
                // int capa=net.nodes[currnode].inEdges.get(i).capacity;
                if (cFlow > 0) {
                    if (cFlow >= inflow) {
                        //Global.net.nodes[currnode].inEdges.get(i).currFlow = net.nodes[currnode].inEdges.get(i).currFlow - inflow;
                        if (currnode != 0) {
                            pot = currnode + " " + pot;
                        } else {
                            pot = "0";
                        }
                        obiskani[currnode]=true;
                        System.out.println("inflow: "+inflow+" pri currnode: "+currnode+" prostor: "+Global.net.nodes[currnode].outEdges.get(i).capacity);
                        isci(Global.net, Global.net.nodes[currnode].inEdges.get(i).startID, currnode, inflow, pot, zadnja,obiskani);
                        obiskani[currnode]=false;
                        return;
                    } else {
                        inflow = cFlow;
                        //Global.net.nodes[currnode].inEdges.get(i).currFlow = net.nodes[currnode].inEdges.get(i).currFlow- inflow;
                        if (currnode != 0) {
                            pot = currnode + " " + pot;
                        } else {
                            pot = "0";
                        }
                        obiskani[currnode]=true;
                        System.out.println("inflow: "+inflow+" pri currnode: "+currnode+" prostor: "+Global.net.nodes[currnode].outEdges.get(i).capacity);
                        isci(Global.net, Global.net.nodes[currnode].inEdges.get(i).startID, currnode, inflow, pot, zadnja,obiskani);
                        obiskani[currnode]=false;
                        return;
                    }
                }
            }
        }

    }

    public static void again(){

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int st = Integer.parseInt(sc.nextLine());
        String a = "";
        /*
         * String c=sc.nextLine(); while(!c.equals("")){ a=a+c+" "; c=sc.nextLine(); }
         */
        while (sc.hasNext()) {
            a = a + sc.nextLine() + " ";
        }
        String[] b = a.split(" ");
        int pov = b.length / 3;
        //System.out.println(b.length / 3);
        int[][] tabela = new int[b.length / 3][3];
        for (int i = 0; i < pov; i++) {
            tabela[i][0] = Integer.parseInt(b[i * 3]);
            tabela[i][1] = Integer.parseInt(b[i * 3 + 1]);
            tabela[i][2] = Integer.parseInt(b[i * 3 + 2]);
            // System.out.println(tabela[i][0]+" "+tabela[i][1]+" "+tabela[i][2]);
        }

        Global.net = new Network(st);
        int[][] matrika=new int[st][st];
        int[][] pretok=new int[st][st];

        for(int i=0;i<pov;i++){
            Global.net.addConnection(tabela[i][0], tabela[i][1], tabela[i][2]);
            matrika[tabela[i][0]][tabela[i][1]]=tabela[i][2];
            matrika[tabela[i][1]][tabela[i][0]]=-tabela[i][2];
        }
        boolean[] obiskani=new boolean[st];
        obiskani[0]=true;
        Global.matrika=matrika;
        for(int i=1;i<st;i++){
            obiskani[i]=false;
        }

        isci(Global.net, 0, -1, 100, "", st-1,obiskani);

        



        sc.close();
    }
}