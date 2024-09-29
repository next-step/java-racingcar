package racingCar;

import java.util.List;

public class ResultView {
    private final String FORWARD_STRING = "-";

    public void printRaceCondition(List<RacingCar> racingCars) {
        racingCars.forEach(racingCar -> {
            int distance = racingCar.getPosition();
            System.out.println(FORWARD_STRING.repeat(distance));
        });
    }
}
