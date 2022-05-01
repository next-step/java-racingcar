package view;

import model.RacingCars;

public class ResultView {
    private ResultView() {

    }

    public static void printStatus(RacingCars racingCars) {
        racingCars.getValue().forEach(racingCar -> {
            System.out.println("-".repeat(racingCar.getStatus()));
        });
        System.out.println();
    }
}
