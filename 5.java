import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class DFS {
    static Stack<Integer> stack = new Stack<>();
    static ArrayList<String[]> lista = read();
    static boolean[] visited = new boolean[lista.size() - 1];
    static ArrayList<ArrayList<Integer>> matrix = delFirst(lista);
    static ArrayList<Integer> dfsu = new ArrayList<>();

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

    public static void main(String[] args) {
        String[] x = lista.get(lista.size()-1);
        int key = Integer.parseInt(x[0]);
        DFSUtil(key);
    }

    static void DFSUtil(int start) {
        if(start < 1 || start > matrix.size()) {
            System.out.println("BŁĄD");
        }
        else {
            dfs(start);
            if(dfsu.size() != matrix.size()) {
                System.out.println("Graf jest niespójny");
            }
            else {
                System.out.print("Porządek DFS: ");
                print(dfsu);
                System.out.println("Graf jest spójny");
            }
        }
    }

    static void dfs(int start) {
            if (!visited[start - 1]) {
                dfsu.add(start);
                visited[start - 1] = true;
                stack.push(start);
                if (!matrix.get(start - 1).isEmpty()) {
                    for (int i = 0; i < matrix.get(start - 1).size(); i++) {
                        if (!visited[matrix.get(start - 1).get(i) - 1]) {
                            dfs(matrix.get(start - 1).get(i));
                        }
                    }
                }
                if(!stack.isEmpty()) {
                    dfs(stack.pop());
                }
            }
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
        lista.remove(lista.size() - 1);
        return lista;
    }

    static void print(ArrayList<Integer> lista) {
        for (int j = 0; j < lista.size(); j++) {
            if (j == lista.size() - 1) {
                System.out.print(lista.get(j));
            } else {
                System.out.print(lista.get(j) + " ");
            }
        }
        System.out.println();
    }
}
