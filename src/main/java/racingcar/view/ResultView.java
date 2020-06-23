package racingcar.view;

import racingcar.domain.RacingCarPositions;
import racingcar.domain.RacingCars;
import racingcar.utils.Const;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    public static void results(List<String> names, List<RacingCarPositions> racingCarPositions) {
        System.out.println("실행결과");
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