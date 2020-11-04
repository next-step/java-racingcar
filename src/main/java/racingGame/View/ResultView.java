package racingGame.View;

import racingGame.Cars;

import java.util.List;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";

    private ResultView() { }

    static public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    static public void printStatus(Cars cars) {
        List<Integer> positions = cars.getPositions();

        for (Integer position : positions) {
            printDash(position);
        }
        System.out.println();
    }

    static private void printDash(int numDash) {
        for (int i = 0; i < numDash; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
