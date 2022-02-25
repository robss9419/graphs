import java.util.*;

class Bellman {
    static ArrayList<Edge> Edges;
    static ArrayList<Edge> fin;
    static ArrayList<String[]> lista = read();
    static ArrayList<int[]> set = new ArrayList<>();

    public Bellman() {
        this.Edges = new ArrayList<>();
        this.fin = new ArrayList<>();
    }

    static void search() {
        int vertices = lista.size();
        for(int c = 0; c < lista.size(); c++) {
            int[] D = new int[vertices];
            for(int i = 0; i < vertices; i++) {
                D[i] = Integer.MAX_VALUE;
            }
            D[c] = 0;
            for (int i = 1; i < vertices; i++) {
                for (int j = 0; j < Edges.size(); j++) {
                    int u = Edges.get(j).getX() - 1;
                    int v = Edges.get(j).getY() - 1;
                    int length = Edges.get(j).getLength();
                    if (D[u] != Integer.MAX_VALUE && D[u] + length < D[v]) {
                        D[v] = D[u] + length;
                    }
                }
            }
            set.add(D);
        }
    }
    
    static void check() {
        int max = 0;
        for (int i = 0; i < set.size(); i++) {
            for(int x : set.get(i)) {
                if(max < x) {
                    max = x;
                }
            }
        }
        System.out.println(max);

    }

    public static void main(String[] args) {
        Bellman mst = new Bellman();
        doEdges(lista);
        Bellman.search();
        check();
    }

    static ArrayList<String[]> read(){
        Scanner ob = new Scanner(System.in);
        ArrayList<String[]> lista = new ArrayList<>();
        while(ob.hasNextLine()) {
            String str = ob.nextLine();
            if(str == null || str.isEmpty()) {
                break;
            }
            else {
                lista.add(str.split("\\s+"));
            }
        }
        return lista;
    }

    static void doEdges(ArrayList<String[]> arr) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (String[] line : arr) {
            ArrayList<Integer> li = new ArrayList<>();
            for (String x : line) {
                li.add(Integer.parseInt(x));
            }
            list.add(li);
        }
        for(int i = 0; i<list.size(); i++) {
            for(int j = 0; j<list.get(i).size(); j++) {
                if(list.get(i).get(j) == 0){
                    continue;
                }
                else {
                    Bellman.Edges.add(Edge.create(i+1, j+1, list.get(i).get(j)));
                }
            }
        }
    }
}

class Edge {
    private int x;
    private int y;
    private int length;

    public Edge(int x, int y, int length) {
        this.x = x;
        this.y = y;
        this.length = length;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int getLength() {
        return length;
    }

    static Edge create(int x, int y, int length) {
        return new Edge(x, y, length);
    }

}
