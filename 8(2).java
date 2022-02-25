import java.util.*;

class square {
    public static void main(String[] args) {
        ArrayList<String[]> lista = read();
        print(squared(doArrays(lista)));
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

    static ArrayList<ArrayList<Integer>> squared (ArrayList<ArrayList<Integer>> lista) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i = 0; i < lista.size(); i++) { // WIERZCHOLEK
            ArrayList<Integer> li = new ArrayList<>();
            for(int j = 1; j < lista.get(i).size(); j++) { // SASIEDZI WIERZCHOLKA
                if(!li.contains(lista.get(i).get(j))) {
                    li.add(lista.get(i).get(j));
                }
                for(int x = 1; x < lista.get(lista.get(i).get(j) - 1).size(); x++) { // LISTA SASIADOW SASIADA
                    if(!lista.get(i).contains(lista.get(lista.get(i).get(j) - 1).get(x)) && !li.contains(lista.get(lista.get(i).get(j) - 1).get(x))) {
                        li.add(lista.get(lista.get(i).get(j) - 1).get(x));
                    }
                }
            }
            Collections.sort(li);
            arr.add(li);
        }
        return arr;
    }

    static ArrayList<ArrayList<Integer>> doArrays(ArrayList<String[]> arr) {
        ArrayList<ArrayList<Integer>> lista = new ArrayList<>();
        for (String[] line : arr) {
            ArrayList<Integer> li = new ArrayList<>();
            for (String x : line) {
                li.add(Integer.parseInt(x));
            }
            lista.add(li);
        }
        return lista;
    }

    static void print(ArrayList<ArrayList<Integer>> lista) {
        int j = 1;
        for(ArrayList<Integer> x : lista) {
            System.out.print(j + " ");
            for(int i = 0; i < x.size(); i++) {
                if(i == x.size() - 1 ) {
                    System.out.print(x.get(i));
                }
                else {
                    System.out.print(x.get(i) + " ");
                }
            }
            System.out.println();
            j++;
        }
    }
}
