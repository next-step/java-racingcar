package racing_refactoring;

import racing_refactoring.domain.RacingCars;
import racing_refactoring.domain.RacingGame;
import racing_refactoring.domain.RacingWinners;
import racing_refactoring.view.InputDataView;
import racing_refactoring.view.ResultView;

public class RacingMainA {
    public static void main(String[] args) {
        String inputNames = InputDataView.scan("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        int movementCount = InputDataView.scanNumber("시도할 회수는 몇 회 인가요?");

        RacingCars racingCars = new RacingCars(inputNames);
        RacingGame racingGame = new RacingGame(racingCars, movementCount);

        ResultView.printStartLine();
        for (int i = 0; i < movementCount; i++) {
            racingGame.racing();
            ResultView.renderProcess(racingCars);
        }

        RacingWinners winners = RacingWinners.findWinners(racingCars);
        ResultView.renderResult(winners);
    }
}
