/*
 * ResultView.java  1.0.0   2019.10.27
 */
package step2;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 자동차 게임 그래프 출력 부분
 *
 * @author naheenosaur
 * @version 1.0.0
 */
public class ResultView {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String DELIMITER = ", ";
    private static final String END_OF_WINNER_ANNOUNCE = "가 최종 우승했습니다.";

    private List<Graph> graphs;
    private int turn;

    public ResultView(List<Graph> graphs) {
        this.graphs = graphs;
        turn = graphs.get(0).graphs.size() - 1;
    }

    public void show() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);

        for (int game = 1; game <= turn; game++) {
            draws(game);
        }
        getMax();
    }

    private void draws(int turn) {
        for (int i = 0; i < graphs.size(); i++) {
            graphs.get(i).draw(turn);
        }
        System.out.println();
    }

    private void getMax() {

        int max = graphs.stream().map(graph -> graph.graphs.get(turn).length()).max(Integer::compareTo).get();
        List<String> winners = graphs.stream().filter(graph -> graph.graphs.get(turn).length() == max)
                .map(graph -> graph.name).collect(Collectors.toList());

        System.out.print(winners.get(0));
        for (int index = 1; index < winners.size(); index++) {
            System.out.print(DELIMITER);
            System.out.print(winners.get(index));
        }
        System.out.println(END_OF_WINNER_ANNOUNCE);
    }

}
