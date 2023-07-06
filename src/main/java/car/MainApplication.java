package car;

import car.view.model.Count;
import car.view.InputService;
import java.io.IOException;
import car.domain.RacingService;
import car.domain.model.Cars;
import car.view.OutputView;

public class MainApplication {

    private static RacingService racingService;

    public static void main(String[] args) throws IOException {
        // 1. 참여자 목록, 경주 횟수 입력
        InputService.printName();
        String name = InputService.enterCarName();
        InputService.printCount();
        Count count = new Count(InputService.enterCount());

        // 2. 자동차 경주 실행
        racingService = new RacingService(new Cars(name));
        OutputView.printResult();
        for (int i = 0; i < count.getTryCount(); i++) {
            OutputView.printEachRaceResult(racingService.runRaceOnce());
        }

        // 3. 최종 우승자 출력
        OutputView.printEachRaceResult(racingService.getRaceResult());
        OutputView.printWinner(racingService.selectWinner());
    }
}
