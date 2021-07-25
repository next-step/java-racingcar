package UI;

import Car.RacingCar;

import java.util.List;

public class OutputView {
    private StringBuilder stringBuilder;
    private static final String RESULT_INTRO = "실행 결과\n";
    private static final String MOVEMENT = "-";

    public OutputView() {
        stringBuilder = new StringBuilder();
    }

    public void printResult(RacingCar racingCar) {
        stringBuilder.append(RESULT_INTRO);

        List<List<Integer>> results = racingCar.getGameResults();
        results.stream()
                .forEach(result -> drawResult(result));
        System.out.println(stringBuilder);
    }

    private void drawResult(List<Integer> result) {
        for (int moveCount :
                result) {
            drawMovement(moveCount);
            stringBuilder.append('\n');
        }
        stringBuilder.append('\n');
    }

    private void drawMovement(int moveCount) {
        for (int i = 0; i <= moveCount; i++) {
            stringBuilder.append(MOVEMENT);
        }
    }

}
