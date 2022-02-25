import java.util.*;

class MST {
    static ArrayList<Edge> Edges;
    static ArrayList<Edge> fin;
    static ArrayList<String[]> lista = read();
    
    public MST() {
        this.Edges = new ArrayList<>();
        this.fin = new ArrayList<>();
    }

    static class makeset {
        int root, set;
    }

    static int findset(makeset makesets[], int i) {
        if (makesets[i].root != i)
            makesets[i].root = findset(makesets, makesets[i].root);
        return makesets[i].root;
    }

    static void Union(makeset subsets[], int x, int y) {
        int xroot = findset(subsets, x);
        int yroot = findset(subsets, y);

        if (subsets[xroot].set < subsets[yroot].set)
            subsets[xroot].root = yroot;
        else if (subsets[xroot].set > subsets[yroot].set)
            subsets[yroot].root = xroot;
        else {
            subsets[yroot].root = xroot;
            subsets[xroot].set++;
        }
    }

    static void Kruskal() {
      int vertices = lista.size();
      makeset makesets[] = new makeset[vertices];
        for (int i = 0; i < vertices; i++)
            makesets[i] = new makeset();

        for (int v = 0; v < vertices; v++) {
            makesets[v].root = v;
            makesets[v].set = 0;
        }
        int i = 0;
        while (fin.size() < lista.size() - 1) {
            if (i < Edges.size()) {
                int x = findset(makesets, Edges.get(i).getX() - 1);
                int y = findset(makesets, Edges.get(i).getY() - 1);
                if (x != y) {
                    fin.add(Edges.get(i));
                    Union(makesets, x, y);
                }
                i++;
            }
            else {
                System.out.println("Graf nie jest spójny");
                System.exit(0);
            }
        }
        int counter = 0;
        for (i = 0; i < fin.size(); ++i) {
            counter += fin.get(i).getLength();
        }
        System.out.println(counter);
    }

    public static void main(String[] args) {
        MST mst = new MST();
        doEdges(lista);
        Edges.sort(Comparator.comparingInt(Edge::getLength));
        MST.Kruskal();
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
                    MST.Edges.add(Edge.create(i+1, j+1, list.get(i).get(j)));
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
