/*
 * ResultView.java  1.0.0   2019.10.27
 */
package step2;

/**
 * 자동차 게임 그래프 출력 부분
 *
 * @author naheenosaur
 * @version 1.0.0
 */
public class ResultView {
    private static final String RESULT_MESSAGE = "실행결과";

    private Racing racing;
    private StringBuilder[] carsGraph;

    public ResultView(Racing racing) {
        this.racing = racing;
        carsGraph = new StringBuilder[racing.getCarsLength()];
        for (int i = 0; i < carsGraph.length; i++) {
            carsGraph[i] = new StringBuilder();
        }
    }

    public void show() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        int turn = racing.getTurn();
        for (int game = 1; game <= turn; game++) {
            drawCars(game);
        }
    }

    private void drawCars(int turn) {
        int cars = racing.getCarsLength();
        for (int carIndex = 0; carIndex < cars; carIndex++) {
            draw(carIndex, turn);
        }
        System.out.println();
    }

    private void draw(int carIndex, int turn) {
        if (racing.getCar(carIndex).getMoveOfTurn(turn)) {
            carsGraph[carIndex].append("-");
        }
        System.out.println(carsGraph[carIndex]);
    }

}
