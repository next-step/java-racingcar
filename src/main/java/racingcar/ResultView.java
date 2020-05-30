package racingcar;

import java.util.List;

public class ResultView {
    public static List<RacingCarPositions> racingCarPositions;

    public ResultView(List<RacingCarPositions> racingCarPositions) {
        this.racingCarPositions = racingCarPositions;
    }

    public static void results(List<RacingCar> racingCars) {
        System.out.println("실행결과");
        racingCars.forEach(racingCar ->
                System.out.println(racingCar.toString()));
    }

    public static void results2() {
        System.out.println("실행결과");
        racingCarPositions.forEach(carPosition -> {
            carPosition.get().forEach(
                    position -> System.out.println(position.toString())
            );
            System.out.println();
        });
    }

    public static ResultView from(List<RacingCarPositions> racingCarPositions) {
        return new ResultView(racingCarPositions);
    }
}