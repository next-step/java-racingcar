package racingcar.view;

import racingcar.application.RacingCarPositions;
import racingcar.domain.RacingCar;
import racingcar.utils.Const;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    public static void results(List<RacingCar> racingCars, List<RacingCarPositions> racingCarPositions) {
        System.out.println("실행결과");
        racingCarPositions.forEach(carPosition -> {
            IntStream.range(Const.INITIAL_NUM, carPosition.get().size())
                    .forEach(position -> {
                                String print = String.format("%s : %s", racingCars.get(position).getCarName(), carPosition.get().get(position));
                                System.out.println(print);
                            }
                    )
            ;
            System.out.println();
        });
    }
}