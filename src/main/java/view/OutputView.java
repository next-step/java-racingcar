package view;

import model.RacingCar;
import model.RacingCars;
import model.Winners;

public class OutputView {

    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printResult(final RacingCars racingCars) {
        for (final RacingCar racingCar : racingCars.getRacingCars()) {
            System.out.println(racingCar.generateStatus());
        }
        System.out.println();
    }

    public void printWinners(final Winners winners) {
        System.out.println(winners.concatenateNames() + "가 최종 우승했습니다.");
    }
}
