package car;

import car.input.model.Count;
import car.input.InputService;
import java.io.IOException;
import car.racing.RacingService;
import car.racing.model.Cars;
import car.output.OutputView;

public class Application {

    private static RacingService racingService;

    public static void run() throws IOException {
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