package racingcar.view;

import racingcar.domain.RacingCarPositions;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingViews;
import racingcar.utils.Const;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    public static void results(List<String> names, RacingViews racingViews) {
        System.out.println("실행결과");
        List<RacingCarPositions> racingCarPositions = racingViews.get();
        racingCarPositions
                .forEach(carPosition -> {
                    carMovementHistory(names, carPosition);
                    System.out.println();
                });
    }

    private static void carMovementHistory(List<String> names, RacingCarPositions carPosition) {
        IntStream.range(Const.INITIAL_NUM, carPosition.get().size())
                .forEach(position -> {
                            String print = String.format("%s : %s", names.get(position), carPosition.get().get(position));
                            System.out.println(print);
                        }
                );
    }

    public static void whoIsWinner(RacingCars racingCars) {
        System.out.println(racingCars.toString() + "가 최종 우승했습니다.");
    }
}