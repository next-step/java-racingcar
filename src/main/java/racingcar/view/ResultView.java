package racingcar.view;

import racingcar.domain.RacingCarPositions;
import racingcar.domain.RacingCars;

import java.util.List;

public class ResultView {
    public static void results(List<RacingCarPositions> racingCarPositions) {
        System.out.println("실행결과");
        racingCarPositions
                .forEach(carPosition -> {
                    carMovementHistory(carPosition);
                    System.out.println();
                });
    }

    public static void whoIsWinner(RacingCars racingCars) {
        System.out.println(racingCars.toString() + "가 최종 우승했습니다.");
    }

    private static void carMovementHistory(RacingCarPositions carPositions) {
        carPositions
                .get()
                .forEach(car -> System.out.println(car));
    }

}