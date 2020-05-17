package racingCar.UI;

import racingCar.Entity.RacingCar;

import java.util.List;

public class ResultView {
    public void printCarsPosition(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            printPosition(racingCar);
            System.out.println();
        }
        System.out.println();
    }

    private void printPosition(RacingCar racingCar) {
        for (int idx = 0; idx < racingCar.getPosition(); idx++) {
            System.out.print("-");
        }
    }
}
