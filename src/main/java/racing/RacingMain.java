package racing;

import java.util.List;

public class RacingMain {

    private RacingMain() {
        throw new AssertionError();
    }

    public static void main(String[] args) {
        racingGame();
    }

    private static void racingGame() {
        String inputNames = InputView.scan("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        int moveCount = InputView.scanNumber("시도할 회수는 몇 회 인가요?");

        Cars cars = Racing.startRacing(inputNames, moveCount);
        OutputView.printStartLine();

        for (int i = 0; i < moveCount; i++) {
            Racing.racing(cars);
            OutputView.renderProcess(cars);
        }

        List<Car> winners = Winners.findWinners(cars.getCars());
        OutputView.renderResult(winners);
    }
}