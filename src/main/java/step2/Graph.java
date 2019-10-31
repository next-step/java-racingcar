package step2;

public class Graph {

    public static final String CAR_LOG_SYMBOL = "_";

    public String name;
    public StringBuilder graph;

    Graph(Car car) {
        this.name = car.getName();
        this.graph = new StringBuilder();
    }

    public void draw(boolean move) {
        System.out.print(name + " : ");
        if (move) {
            graph.append(CAR_LOG_SYMBOL);
        }
        System.out.println(graph);
    }
}
