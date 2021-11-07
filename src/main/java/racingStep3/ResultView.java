package racingStep3;

import java.util.List;

public class ResultView {
    public static void print(List<RacingCar> cars) {
        for(RacingCar car : cars) {
            String carPosition = car.printCar(car);
            System.out.println(carPosition);
        }
    }
}
