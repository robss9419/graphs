import java.util.*;

class init {

    public static ArrayList<ArrayList<Integer>> lista = delFirst(read());
    public static int arr[] = new int [lista.size()];
    public static ArrayList<ArrayList<Integer>> fin = new ArrayList<>();
    public static HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    public static int assocation[] = new int [4];

    public static void main(String[] args) {
        boolean[] all = bfs(1);
        ArrayList<Integer> first = bigraph();
        Arrays.fill(assocation, -1);
        for(int i = 0; i<first.size(); i++) {
            for(int j = 0; j<lista.get(first.get(i) - 1).size(); j++) { //SPRAWDZAMY CZY SA WOLNI KAWALERZY
                if(!hm.containsValue(lista.get(first.get(i) - 1).get(j))) {
                    hm.put(first.get(i), lista.get(first.get(i) - 1).get(j));
                    break;
                }
                else if (j == lista.get(first.get(i) - 1).size() - 1) {      // JEZELI PRZESZLISMY WSZYSTKICH KAWALEROW I NIE MA ZADNEGO WOLNEGO TO
                    for (int w = 0; w < lista.get(first.get(i) - 1).size(); w++) {  // BEDZIEMY SZUKAAC WOLNEGO KAWALERA U POPRZEDNIKA
                        for(Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                            if(entry.getValue() == lista.get(first.get(i) -1).get(w)) {
                                if(checkNeighbours(entry.getKey() - 1)) {
                                    hm.put(first.get(i), lista.get(first.get(i) - 1).get(w));
                                }
                            }
                        }
                    }
                }
            }
        }
        if(hm.size() == first.size() && checkvis(all)) {
            System.out.println("Istnieje skojarzenie doskonałe");
        }
        else {
            System.out.println("Nie istnieje skojarzenie doskonałe");
        }
    }

    static ArrayList<Integer> bigraph() {
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                first.add(i+1);
            }
            else {
                second.add(i+1);
            }
        }
        fin.add(first);
        fin.add(second);
        if(first.size() < second.size())
            return first;
        return second;
    }

    static boolean checkvis(boolean[] all) {
        for(boolean x : all) {
            if(!x) {
                return false;
            }
        }
        return true;
    }

    static boolean checkNeighbours(int i) {
        ArrayList<Integer> propos = new ArrayList<>();
        for(int j = 0; j < lista.get(i).size(); j++) {
            for(Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                if (entry.getValue() == lista.get(i).get(j)) {
                    break;
                }
                if(entry.getValue() != lista.get(i).get(j)){
                    propos.add(lista.get(i).get(j));
                }
                if(j == lista.get(i).size() - 1 && !propos.isEmpty()) {
                    hm.put(i+1, propos.get(0));
                    return true;
                }
            }
        }
        return false;
    }

    static boolean[] bfs(int s) {
        LinkedList<Integer> que = new LinkedList<>();
        Arrays.fill(arr, -1);
        que.add(s-1);
        boolean visited[] = new boolean[lista.size()];
        visited[s-1] = true;
        arr[s-1] = 1;
        while(que.size() != 0) {
            int x = que.poll();
            for(int i = 0; i<lista.get(x).size(); i++){
                if(!visited[lista.get(x).get(i) - 1]) {
                    visited[lista.get(x).get(i) - 1] = true;
                    que.add(lista.get(x).get(i) - 1);
                }
                if(arr[x] == 1 && arr[lista.get(x).get(i) - 1] == -1){
                    arr[lista.get(x).get(i) - 1] = 2;
                }
                else if(arr[x] == 2 && arr[lista.get(x).get(i) - 1] == -1) {
                    arr[lista.get(x).get(i) - 1] = 1;
                }
                else if(arr[x] == 2 && arr[lista.get(x).get(i) - 1] == 2 || arr[x] == 1 && arr[lista.get(x).get(i) - 1] == 1){
                    System.out.println("Graf nie jest dwudzielny");
                    System.exit(0);
                }
            }
        }
        return visited;
    }

    static ArrayList<String[]> read(){
        Scanner ob = new Scanner(System.in);
        ArrayList<String[]> lista = new ArrayList<>();
        while(ob.hasNextLine()) {
            String str = ob.nextLine();
            if(str == null || str.isEmpty())
            {
                break;
            }
            else {
                lista.add(str.split(" "));
            }
        }
        return lista;
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
}
