package step2.Model;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private String name;
    private List<String> graphs;

    private Graph(String name) {
        this.name = name;
        this.graphs = new ArrayList<>();
    }

    public static List<Graph> createList(List<Car> carList) {
        List<Graph> result = new ArrayList<>();
        for (Car car : carList) {
            result.add(new Graph(car.getName()));
        }
        return result;
    }

    public void addGraph(String graph) {
        graphs.add(graph);
    }

    public String draw(int turn) {
        return name + " : " + graphs.get(turn);
    }

    public void addWinner(List<String> winners, int max) {
        if (isWinner(max)) {
            winners.add(name);
        }
    }

    public int finalPosition() {
        return getLength(graphs.size() - 1);
    }

    private boolean isWinner(int max) {
        return finalPosition() == max;
    }

    private int getLength(int turn) {
        return graphs.get(turn).length();
    }

}
