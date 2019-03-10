package racingcar;

import java.util.List;

public class ResultView {

    public void printResult(List<RacingCar> racingCars) {
        System.out.println("\n");
        racingCars.forEach(racingCar -> {
            System.out.println(racingCar.printPosition());
        });
    }
}
