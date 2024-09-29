package racingCar;

import java.util.List;

public class ResultView {
    public void printRaceCondition(List<RacingCar> racingCars) {
        System.out.println("실행 결과");

        racingCars.forEach(racingCar -> {
            int distance = racingCar.getPosition();
            System.out.println("-".repeat(distance)););
        });
    }
}
