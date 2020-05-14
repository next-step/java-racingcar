package racingCar.UI;

import racingCar.Entity.RacingCar;

import java.util.List;

public class ResultView {

    public void printResult(List<RacingCar> racingCarList, int time) {
        System.out.println("실행 결과");
        for (int idx = 0; idx < time; idx++) {
            printCarsPosition(racingCarList);
            System.out.println();
        }
    }

    public void printCarsPosition(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            printPosition(racingCar);
        }
    }

    public void printPosition(RacingCar racingCar) {
        for (int idx = 0; idx < racingCar.getPosition(); idx++) {
            System.out.print("-");
        }
    }
}
