/*
 * ResultView.java  1.0.0   2019.10.27
 */
package step2;

import java.util.Arrays;

/**
 * 자동차 게임 그래프 출력 부분
 *
 * @author naheenosaur
 * @version 1.0.0
 */
public class ResultView {
    private static final String RESULT_MESSAGE = "실행결과";

    private Racing racing;

    private Graph[] carsGraph;

    public ResultView(Racing racing) {
        this.racing = racing;
        carsGraph = Arrays.stream(racing.getCars())
                .map(Graph::new).toArray(Graph[]::new);
    }

    public void show() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        int turn = racing.getTurn();
        Car[] cars = racing.getCars();
        for (int game = 1; game <= turn; game++) {
            draws(cars, game);
        }
    }

    public void draws(Car[] cars, int turn) {

        for (int i = 0; i < cars.length; i++) {
            Graph graph = carsGraph[i];
            graph.draw(cars[i].getMoveOfTurn(turn));
        }
        System.out.println();
    }


}
