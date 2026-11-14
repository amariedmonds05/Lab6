
public class Main {

    // https://github.com/amariedmonds05/Lab6.git
    public static void main(String[] args) {

        Graph g = new Graph(5);

        g.readFile("edges.txt");

        System.out.println("DFS using Adjacency List:");
        g.DFS_List(0);

        System.out.println();

        System.out.println("DFS using Adjacency Matrix:");
        g.DFS_Matrix(0);
    }
}
