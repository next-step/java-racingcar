package racingcar.view;

import racingcar.race.Car;
import racingcar.race.RacingCars;
import racingcar.race.RacingModel;

public class ResultView {
    private RacingCars racingCars;
    private RacingModel racingModel;

    public ResultView(RacingCars racingCars, RacingModel racingModel) {
        this.racingCars = racingCars;
        this.racingModel = racingModel;
    }

    public void printEachRacingStep() {
        for (Car racingCar : racingCars.getRacingCars()) {
            printCarPosition(racingCar);
        }
        System.out.println();
    }

    private void printCarPosition(Car racingCar) {
        for (int current = 0; current < racingCar.getPosition(); current++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
