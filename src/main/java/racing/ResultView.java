package racing;

import java.util.List;

public class ResultView {

    public void printResult(List<RacingCar> racingCars) {
        System.out.println();
        racingCars.forEach(racingCar -> {
            System.out.println(racingCar.carPosition());
        });
    }
}
