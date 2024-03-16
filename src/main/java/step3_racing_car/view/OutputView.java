package step3_racing_car.view;

import step3_racing_car.domain.RacingCar;
import step3_racing_car.domain.RacingCars;

public class OutputView {
    public static void printRoundResult(RacingCars racingCars) {
        System.out.println("실행결과");
        for (RacingCar car : racingCars.getItems()) {
            System.out.println(car.toString());
        }
    }

    public static void printGameWinner(RacingCars racingCars) {
        System.out.println("게임 우승자: " + racingCars.toString());
    }
}
