
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Graph {

    private int vertices_no;
    private ArrayList<ArrayList<Integer>> adj_list;
    private int[][] adj_matrix;

    // Constructor
    public Graph(int vertices_no) {

        this.vertices_no = vertices_no;
        this.adj_list = new ArrayList<>();
        this.adj_matrix = new int[vertices_no][vertices_no];

        for (int i = 0; i < this.vertices_no; i++) {
            this.adj_list.add(new ArrayList<>());
        }
    }

    // Add edges to both graph representations
    public void add_edges(int from, int to) {

        this.adj_list.get(from).add(to);
        this.adj_list.get(to).add(from);

        this.adj_matrix[from][to] = 1;
        this.adj_matrix[to][from] = 1;
    }

    // Read graph information from a text file
    public void readFile(String filename) {

        try {
            Scanner input = new Scanner(new File(filename));

            while (input.hasNextInt()) {

                int from = input.nextInt();
                int to = input.nextInt();

                add_edges(from, to);
            }

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    // DFS using Adjacency List
    public void DFS_List(int start_node) {

        boolean[] visited = new boolean[this.vertices_no];

        DFS_List_Recursive(start_node, visited);
    }

    private void DFS_List_Recursive(int node, boolean[] visited) {

        visited[node] = true;

        System.out.println("Visiting: " + node);

        for (int neighbour : this.adj_list.get(node)) {

            if (!visited[neighbour]) {
                DFS_List_Recursive(neighbour, visited);
            }
        }
    }

    // DFS using Adjacency Matrix
    public void DFS_Matrix(int start_node) {

        boolean[] visited = new boolean[this.vertices_no];

        DFS_Matrix_Recursive(start_node, visited);
    }

    private void DFS_Matrix_Recursive(int node, boolean[] visited) {

        visited[node] = true;

        System.out.println("Visiting: " + node);

        for (int i = 0; i < this.vertices_no; i++) {

            if (this.adj_matrix[node][i] == 1 && !visited[i]) {
                DFS_Matrix_Recursive(i, visited);
            }
        }
    }
}
