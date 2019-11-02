package step2.Model;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public static final String CAR_LOG_SYMBOL = "_";

    public String name;
    public List<String> graphs;

    Graph(Car car) {
        this.name = car.getName();
        graphs = new ArrayList<>();
    }

    public void setGraph(int score) {
        StringBuilder graph = new StringBuilder();
        for (int i = 0; i < score; i++) {
            graph.append(CAR_LOG_SYMBOL);
        }
        graphs.add(graph.toString());
    }

    public void draw(int turn) {
        System.out.print(name + " : ");
        System.out.println(graphs.get(turn));
    }

}
