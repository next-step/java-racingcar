package racingcar;

import java.util.List;

public class ResultView {
    public static void results(List<RacingCar> racingCars) {
        System.out.println("실행결과");
        racingCars.forEach(racingCar ->
                System.out.println(racingCar.toString()));
    }
}