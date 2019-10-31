/*
 * ResultView.java  1.0.0   2019.10.27
 */
package step2;

import java.util.List;

/**
 * 자동차 게임 그래프 출력 부분
 *
 * @author naheenosaur
 * @version 1.0.0
 */
public class ResultView {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String END_OF_WINNER_ANNOUNCE = "가 최종 우승했습니다.";

    private List<Graph> graphs;
    private int turn;

    public ResultView(List<Graph> graphs) {
        this.graphs = graphs;
        turn = graphs.get(0).graphs.size();
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
//        Arrays.sort(carsGraph, (o1, o2) ->
//                (o1.graphs.get(o1.graphs.size()).length() < o2.graphs.get(o2.graphs.size()).length()) ? 0 : 1);
//        int max = carsGraph[0].graph.length();
//        Arrays.stream(carsGraph).filter(carGraph -> carGraph.graph.length() == max)
//                .forEach(carGraph -> System.out.print(carGraph.name + " "));
        System.out.println(END_OF_WINNER_ANNOUNCE);
    }

}
