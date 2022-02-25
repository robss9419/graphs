import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class hamilton {

    public static ArrayList<String[]> lista = read();
    public static ArrayList<ArrayList<Integer>> fin = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> solution = new ArrayList<>();
    public static Stack<Integer> stack = new Stack<>();
    public static boolean visited[] = new boolean[lista.size()];

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ms = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            ms.add(new ArrayList<>());
            solution.add(new ArrayList<>());
        }
        fin = doEdges(lista, ms);
        stack.push(0);
        dfs(stack.peek() + 1);
        hamPath(stack.peek());
    }

    static void dfs(int start) {
        if (!visited[start - 1]) {
            visited[start - 1] = true;
            stack.push(start);
            if (!fin.get(start - 1).isEmpty()) {
                for (int i = 0; i < fin.get(start - 1).size(); i++) {
                    if (!visited[fin.get(start - 1).get(i) - 1]) {
                        dfs(fin.get(start - 1).get(i));
                    }
                }
            }
            if(!stack.isEmpty()) {
                dfs(stack.pop());
            }
        }
    }

    static void hamPath(int i) {
        for(int j = 0; j < fin.get(i).size(); j++) {
            int neighbour = fin.get(i).get(j) - 1;

            if(!stack.contains(neighbour) && !solution.get(i).contains(neighbour)) {
                stack.push(neighbour);
                solution.get(i).add(neighbour);
                if(stack.size() == fin.size()) {
                    if(fin.get(neighbour).contains(1)) {
                        System.out.println("Graf jest hamiltonowski");
                    }
                    else {
                        System.out.println("Graf jest półhamiltonowski");
                    }
                    System.exit(0);
                }
                hamPath(neighbour);
            }
            if(j == fin.get(i).size() - 1) {
                if(!stack.isEmpty()) {
                    hamPath(stack.pop());
                }
                else {
                    for(boolean x : visited) {
                        if(x == false) {
                            System.out.println("Graf jest niespójny");
                            System.exit(0);
                        }
                    }
                    System.out.println("Graf nie jest hamiltonowski");
                    System.exit(0);
                }
            }
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> ms, int source, int dest) {
        ms.get(source).add(dest);
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

    static ArrayList<ArrayList<Integer>> doEdges(ArrayList<String[]> lista, ArrayList<ArrayList<Integer>> ms) {
        int l = 0;
        for(String[] line : lista){
            int c = 1;
            for(String col: line) {
                if (col.equals("1")){
                    addEdge(ms, l, c);
                }
                c += 1;
            }
            l += 1;
        }
        return ms;
    }
}
