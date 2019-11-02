package step2.Model;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public String name;
    public List<String> graphs;

    Graph(String name) {
        this.name = name;
        graphs = new ArrayList<>();
    }

    public static List<Graph> createList(List<Car> carList) {
        List<Graph> result = new ArrayList<>();
        for (Car car : carList) {
            result.add(new Graph(car.getName()));
        }
        return result;
    }

    public List<String> addGraph(String graph) {
        this.graphs.add(graph);
        return graphs;
    }

    public String draw(int turn) {
        return name + " : " + graphs.get(turn);
    }

}
