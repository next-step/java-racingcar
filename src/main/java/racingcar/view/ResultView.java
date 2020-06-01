package racingcar.view;

import racingcar.application.RacingCarPositions;

import java.util.List;

public class ResultView {
    public static void results(List<RacingCarPositions> racingCarPositions) {
        System.out.println("실행결과");
        racingCarPositions.forEach(carPosition -> {
            carPosition.get().forEach(
                    position -> System.out.println(position.toString())
            );
            System.out.println();
        });
    }
}