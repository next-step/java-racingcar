package racingcar.view;

import racingcar.service.RacingCarService;
import java.util.Map;

public class ResultView {
    private static final RacingCarService racingCarService = new RacingCarService();

    public void printCarStatusResult() {
        System.out.println("실행 결과");

        Map<Integer, String> carMovementStatuses = racingCarService.getCarMoveStatuses();

        for(int i = 0; i < carMovementStatuses.size(); i++) {
            System.out.println(carMovementStatuses.get(i));
        }

        System.out.println();
    }
}
