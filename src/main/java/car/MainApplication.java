package car;

import car.domain.RacingService;
import car.view.InputView;
import car.view.OutputView;

public final class MainApplication {

    public static void main(String[] args) {
        // 1. 참여자 목록, 경주 횟수 입력
        String inputCarNames = InputView.enterCarName();
        int inputCount = InputView.enterCount();

        // 2. 자동차 경주 실행
        RacingService racingService = new RacingService(inputCarNames, inputCount);
        while (racingService.isRacing()) {
            racingService.runRaceOnce();
            OutputView.printEachRaceResult(racingService.getEachRaceResult());
        }

        // 3. 최종 우승자 출력
        OutputView.printEachRaceResult(racingService.getEachRaceResult());
        OutputView.printWinner(racingService.selectWinner());
    }
}
