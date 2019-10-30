package step2;

public class Graph {
    public String nemw;
    public StringBuilder graph;

    Graph(Car car) {
        this.nemw = car.getName();
        this.graph = new StringBuilder();
    }

    public void draw(boolean move) {
        System.out.print(nemw + " : ");
        if (move) {
            graph.append("-");
        }
        System.out.println(graph);
    }



}
