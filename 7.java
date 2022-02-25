import java.util.*;

public class Main {

    public static ArrayList<Integer> temp = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> array = doArr(read());
    
    public static void main(String[] args) {
        for(int i = 0; i < temp.size(); i++) { // iteracja po kazdym wierzcholku posortowany od largest
            ArrayList<Integer> colors = new ArrayList<>();
            for(int j = 0; j < array.get(i).size(); j++) { // iteracja po kazdym sąsiedzie wierzcholka
                colors.add(temp.get(array.get(i).get(j) - 1) - 1);
            }
            for(int j = 0; j < colors.size(); j++) {
                Integer t = temp.get(i) - 1;
                if (t.equals(colors.get(j))){
                    System.out.println("Graf nie jest kolorowalny");
                    System.exit(0);
                }
            }
        }
        System.out.println("Graf jest kolorowalny");
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
        for(int i = 0 ; i < lista.get(lista.size() - 1).size(); i++) {
            temp.add((lista.get(lista.size() - 1).get(i)));
        }
        lista.remove(lista.size() - 1);
        for(int i = 0; i < lista.size(); i++) {
            lista.get(i).remove(0);
        }
        return lista;
    }

    static ArrayList<String[]> read(){
        Scanner ob = new Scanner(System.in);
        ArrayList<String[]> lista = new ArrayList<>();
        int x = 0;
        while(ob.hasNextLine()) {
            String str = ob.nextLine();
            if(str == null || str.isEmpty()) {
                if(x < 1) {
                    x++;
                    continue;
                }
                break;
            }
            else {
                lista.add(str.split("\\s+"));
            }
        }
        return lista;
    }
}
