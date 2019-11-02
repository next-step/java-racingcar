package step2.Dao;

import step2.Model.Graph;

import java.util.ArrayList;
import java.util.List;

public class ResultData {
    private static final String DELIMITER = ", ";
    private List<Graph> graphs;

    public ResultData(List<Graph> result) {
        this.graphs = result;
    }

    public void drawByTurn(int turn) {
        for (Graph carResult : graphs) {
            System.out.println(carResult.draw(turn));
        }
        System.out.println();
    }

    public String getMax() {
        List<String> winners = getWinners(graphs);

        StringBuilder winner = new StringBuilder();
        winner.append(winners.get(0));
        for (int index = 1; index < winners.size(); index++) {
            winner.append(DELIMITER);
            winner.append(winners.get(index));
        }
        return winner.toString();
    }

    private List<String> getWinners(List<Graph> graphs) {
        int max = graphs.stream().map(Graph::finalPosition)
                .max(Integer::compareTo).orElse(0);
        List<String> winners = new ArrayList<>();
        graphs.forEach(graph -> graph.addWinner(winners, max));
        return winners;
    }

}
