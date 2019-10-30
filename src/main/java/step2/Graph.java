package step2;

public class Graph {
    public String name;
    public StringBuilder graph;

    Graph(Car car) {
        this.name = car.getName();
        this.graph = new StringBuilder();
    }

    public void draw(boolean move) {
        System.out.print(name + " : ");
        if (move) {
            graph.append("-");
        }
        System.out.println(graph);
    }
}
