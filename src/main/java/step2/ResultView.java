/*
 * ResultView.java  1.0.0   2019.10.27
 */
package step2;

/**
 * 자동차 게임 그래프 출력 부분
 * @version 1.0.0
 * @author naheenosaur
 */
public class ResultView {
    private static final String RESULT_MESSAGE = "실행결과";
    int turn;
    Car[] cars;
    StringBuilder[] carsGraph;

    public ResultView(Racing racing) {
        turn = racing.turn;
        cars = racing.cars;
        carsGraph = new StringBuilder[cars.length];
        for (int carIndex = 0; carIndex < cars.length; carIndex++) {
            carsGraph[carIndex] = new StringBuilder();
        }
    }

    public void show() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        for (int game = 1; game <= turn; game++) {
            drawCars(game);
        }
    }

    private void drawCars(int turn) {
        for (int carIndex = 0; carIndex < cars.length; carIndex++) {
            draw(carIndex, turn);
        }
        System.out.println();
    }

    private void draw(int carIndex, int turn) {
        if (cars[carIndex].getMove(turn)) {
            carsGraph[carIndex].append("-");
        }
        System.out.println(carsGraph[carIndex]);
    }

}
