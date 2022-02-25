Napisz program, który pobierze od użytkownika macierz sąsiedztwa grafu G (wierzchołki numerujemy od jedynki), a następnie
wyświetli następujące informacje (każda informacja w osobnej linii):

    Ilość wierzchołków
    Ilość krawędzi
    Ciąg stopni (nieposortowane)
    Średni stopień grafu
    Informacja czy graf jest pełny/cykl/ścieżka/drzewo/lub nie należy do żadnych

Sprawdzamy w podanej powyżej kolejności i wypisujemy każdy poprawny wynik. Zakładamy dla prostoty, że grafy są spójne, ale dopuszczamy wierzchołki izolowane.

import java.util.*;

class Main {
    public static void main(String[] args) {
        ArrayList<String[]> lista = read();
        int edges = countEdge(doEdges(delFirst(lista)));
        int vertex = lista.size();
        System.out.println("Ilość wierzchołków: " + vertex);
        System.out.println("Ilość krawędzi: " + edges);
        print(countDegree(delFirst(lista)));
        mediumDegree(delFirst(lista));
        check(lista);
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
                lista.add(str.split(" "));
            }
        }
        return lista;
    }

    static void check(ArrayList<String[]> lista) {
        int counter = 0;
        int edges = countEdge(doEdges(delFirst(lista)));
        int vertex = lista.size();
        if(fullgraph(doEdges(delFirst(lista)))) {
            System.out.println("Jest to graf pełny.");
            counter++;
        }
        if(isTrack(delFirst(lista))) {
            System.out.println("Jest to ścieżka.");
            counter++;
        }
        if(isCyclic(vertex, edges)) {
            System.out.println("Jest to cykl.");
            counter++;
        }
        if(isTree(vertex, edges, countDegree(delFirst(lista)))) {
            System.out.println("Jest to drzewo.");
            counter++;
        }
        if(counter == 0) {
            System.out.println("Graf nie należy do żadnej z podstawowych klas.");
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> ms, int source, int dest) {
        ms.get(source).add(dest);
    }

    static boolean checkDuplicate(ArrayList<Integer> ms, Integer targetValue) {
        for(Integer s: ms){
            if (s.equals(targetValue))
                return false;
        }
        return true;
    }

    static ArrayList<ArrayList<Integer>> doEdges(ArrayList<ArrayList<Integer>> lista) {
        ArrayList<ArrayList<Integer>> ms = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            ms.add(new ArrayList<>());
        }
        for(int i = 0; i < lista.size(); i++) {
            for(int x : lista.get(i)) {
                if (checkDuplicate(ms.get(x - 1), i + 1) && (x - 1) != i) {
                    addEdge(ms, i, x);
                }
            }
        }
        return ms;
    }

    static ArrayList<Integer> countDegree(ArrayList<ArrayList<Integer>> lista) {
        ArrayList<Integer> cd = new ArrayList<>();
        for(int i = 0; i < lista.size(); i++) {
            int counter = 0;
            for (int x : lista.get(i)) {
                counter++;
            }
            cd.add(counter);
        }
        return cd;
    }

    static int countEdge(ArrayList<ArrayList<Integer>> lista) {
        int counter = 0;
        for(int i = 0; i < lista.size(); i++) {
            for(int j = 0; j < lista.get(i).size(); j++) {
                counter ++;
            }
        }
        return counter;
    }

    static ArrayList<ArrayList<Integer>> delFirst(ArrayList<String[]> arr) {
        ArrayList<ArrayList<Integer>> lista = new ArrayList<>();
        for (String[] line : arr) {
            ArrayList<Integer> li = new ArrayList<>();
            for (String x : line) {
                li.add(Integer.parseInt(x));
            }
            lista.add(li);
        }
        for(int i = 0; i < lista.size(); i++){
            lista.get(i).remove(0);
        }
        return lista;
    }

    static void print(ArrayList<Integer> lista) {
        System.out.print("Stopnie wierzchołków: ");
        for (int j = 0; j < lista.size(); j++) {
            if (j == lista.size() - 1) {
                System.out.print(lista.get(j));
            } else {
                System.out.print(lista.get(j) + " ");
            }
        }
        System.out.println();
    }

    static void mediumDegree(ArrayList<ArrayList<Integer>> lista) {
        int counter = 0;
        for(int i = 0; i < lista.size(); i++) {
            for(int j = 0; j < lista.get(i).size(); j++) {
                counter ++;
            }
        }
        if(counter % lista.size() == 0) {
            System.out.print("Średni stopień: " + counter / lista.size() +"\n");
        }
        else {
            double result = (double) counter / (double) lista.size();
            double rs = Math.round(result * 100.00) / 100.00;
            System.out.print("Średni stopień: " + rs +"\n");
        }
    }

    static boolean fullgraph(ArrayList<ArrayList<Integer>> lista) {
        int n = lista.size();
        int counter = 0;
        for(int i = 0; i < lista.size(); i++) {
            for(int j = 0; j < lista.get(i).size(); j++) {
                counter++;
            }
        }
        if(counter == (n*(n-1)) / 2){
            return true;
        }
        else {
            return false;
        }
    }

    static boolean isTrack(ArrayList<ArrayList<Integer>> lista){
        if(lista.get(0).size() == 1 && lista.get(lista.size()-1).size() == 1){
            for(int i = 1; i < lista.size() - 1; i++) {
                if(lista.get(i).size() != 2) {
                    return false;
                }
            }
            return true;
        }
        else {
            return false;
        }
    }

    static boolean isCyclic(int size, int edges){
        if(edges == size) {
            return true;
        }
        else {
            return false;
        }
    }

    static boolean isTree(int v, int e, ArrayList<Integer> lista) {
        if(v > e && isIsolated(lista)) {
            return true;
        }
        return false;
    }

    static boolean isIsolated(ArrayList<Integer> lista) {
        for(int i = 0; i < lista.size(); i++) {
            if(lista.get(i) < 1) {
                return false;
            }
        }
        return true;
    }
}
