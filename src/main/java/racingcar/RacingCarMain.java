package racingcar;


import racingcar.domain.CarManager;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarMain {
    private static String INPUT_NAMES_OF_CAR_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static String INPUT_TIMES_OF_RUN_MSG = "시도할 횟수는 몇회 인가요?";
    private static String RESULT_MSG = "실행 결과";

    public static void main(String[] args) {
        OutputView.printTitleMsg(INPUT_NAMES_OF_CAR_MSG);
        List<String> namesOfCar = InputView.inputNamesOfCar();

        OutputView.printTitleMsg(INPUT_TIMES_OF_RUN_MSG);
        int timesOfRun = InputView.inputTimesOfRun();

        RacingGame racingGame = new RacingGame(CarManager.createCarsByCnt(namesOfCar));

        OutputView.printTitleMsg(RESULT_MSG);
        for (int i = 0; i < timesOfRun; i++) {
            racingGame.race();
            OutputView.printRaceResult(racingGame.getRaceResult());
        }
        OutputView.printWinners(racingGame.getWinners());

    }
}