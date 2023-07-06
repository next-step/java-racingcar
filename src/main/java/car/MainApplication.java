package car;

import car.domain.RacingService;
import car.view.InputView;
import car.view.OutputView;
import java.io.IOException;

public class MainApplication {

    public static void main(String[] args) throws IOException {
        // 1. 참여자 목록, 경주 횟수 입력
        String inputCarNames = InputView.enterCarName();
        int inputCount = InputView.enterCount();

        // 2. 자동차 경주 실행
        RacingService racingService = new RacingService(inputCarNames, inputCount);
        for (int i = 0; i < inputCount; i++) {
            OutputView.printEachRaceResult(racingService.runRaceOnce());
        }

        // 3. 최종 우승자 출력
        OutputView.printEachRaceResult(racingService.getRaceResult());
        OutputView.printWinner(racingService.selectWinner());
    }
}
