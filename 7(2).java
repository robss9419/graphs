import java.util.*;

public class Main {

    public static ArrayList<ArrayList<Integer>> array = doArr(read());
    public static ArrayList<Edge> Edges = new ArrayList<>();
    public static int[] usedColor = new int[array.size()];
    public static ArrayList<Integer> vertices = new ArrayList<>();

    public static void main(String[] args) {
        doEdges();
        sortVertices();
        for(int i = 0; i < vertices.size(); i++) { // iteracja po kazdym wierzcholku posortowany od largest
            boolean[] colors = new boolean[array.size()];
            for(int j = 0; j < array.get(vertices.get(i) - 1).size(); j++) { // iteracja po kazdym sąsiedzie wierzcholka
                if(usedColor[array.get(vertices.get(i) - 1).get(j) - 1] != 0) { // zaznaczamy jakie kolory byly uzyte
                    colors[usedColor[array.get(vertices.get(i) - 1).get(j) - 1] - 1] = true;
                }
            }
            for(int j = 0; j < colors.length; j++) {
                if (colors[j]){
                    continue;
                }
                else {
                    usedColor[vertices.get(i) - 1] = j+1;
                    break;
                }
            }
        }
        print();
        getMax();
    }

    static void print() {
        System.out.print("Pokolorowanie wierzchołków: ");
        for(int i = 0; i < usedColor.length; i++) {
            if (i == usedColor.length - 1)
                System.out.print(usedColor[i]);
            else
                System.out.print(usedColor[i] + " ");
        }
        System.out.println();
    }

    static void getMax() {
        int max = 0;
        for(Integer x : usedColor) {
            if(x > max) {
                max = x;
            }
        }
        System.out.println("Liczba chromatyczna == " + max);
    }

    static void doEdges() {
        for(int i = 0; i < array.size(); i++) {
            for(int j = 0; j < array.get(i).size(); j++) {
                Edges.add(Edge.create((i + 1), array.get(i).get(j), array.get(i).size()));
            }
        }
    }

    static void sortVertices() {
        Comparator<Edge> compareByDegree = Comparator.comparing(Edge::getDegree);
        Comparator<Edge> compareByX = Comparator.comparing(Edge::getX);
        Comparator<Edge> full = compareByDegree.thenComparing(compareByX);
        Edges.sort(full.reversed());
        for(int i = 0; i < Edges.size(); i++) {
            if(vertices.contains(Edges.get(i).getX())) {
                continue;
            }
            else {
                vertices.add(Edges.get(i).getX());
            }
        }
    }

    static ArrayList<ArrayList<Integer>> doArr (ArrayList<String[]> arr) {
        ArrayList<ArrayList<Integer>> lista = new ArrayList<>();
        for(String[] line : arr) {
            ArrayList<Integer> li = new ArrayList<>();
            for(String s : line) {
                li.add(Integer.parseInt(s));
            }
            lista.add(li);
        }
        for(int i = 0; i < lista.size(); i++) {
            lista.get(i).remove(0);
        }
        return lista;
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
}

class Edge {
    private Integer x;
    private int y;
    private int degree;

    public Edge(Integer x, int y, int degree) {
        this.x = x;
        this.y = y;
        this.degree = degree;
    }

    public int getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public static Edge create(Integer x, int y, int degree) {
        return new Edge(x, y, degree);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "x=" + x +
                ", y=" + y +
                ", degree=" + degree +
                '}';
    }
}
