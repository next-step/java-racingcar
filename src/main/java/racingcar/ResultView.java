package racingcar;

import java.util.Scanner;

public class ResultView {

    public void roundLogTrace(RacingCar[] racingCars) {
        for (RacingCar racingCar : racingCars) {
            distanceToHyphen(racingCar);
            System.out.println();
        }
        System.out.println();
    }

    private void distanceToHyphen(RacingCar racingCar) {
        for (int i = 0; i < racingCar.getDistance(); i++) {
            System.out.print("-");
        }
    }

}
