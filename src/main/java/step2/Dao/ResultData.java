package step2.Dao;

import step2.Model.Graph;

import java.util.List;
import java.util.stream.Collectors;

public class ResultData {
    private static final String DELIMITER = ", ";
    List<Graph> graphs;

    public ResultData(List<Graph> result) {
        this.graphs = result;
    }

    public void drawByTurn(int turn) {
        for (Graph carResult : graphs) {
            System.out.println(carResult.draw(turn));
        }
        System.out.println();
    }

    public String getMax(int turn) {
        int max = graphs.stream().map(graph -> graph.graphs.get(turn - 1).length())
                .max(Integer::compareTo).get();
        List<String> winners = graphs.stream()
                .filter(graph -> graph.graphs.get(turn - 1).length() == max)
                .map(graph -> graph.name).collect(Collectors.toList());

        StringBuilder winner = new StringBuilder();
        winner.append(winners.get(0));
        for (int index = 1; index < winners.size(); index++) {
            winner.append(DELIMITER);
            winner.append(winners.get(index));
        }
        return winner.toString();
    }
}
