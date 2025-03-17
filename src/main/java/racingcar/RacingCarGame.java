package racingcar;

import java.util.List;

public class RacingCarGame {

    public static void start() {
        RacingCarInput input = new RacingCarInput();
        process(input);
    }

    private static void process(RacingCarInput input) {
        List<RacingCar> racingCars = RacingCar.createRacingCars(input.getCarCount());

        for (int i = 0; i < input.getTryCount(); i++) {
            RacingCar.moveIfMovable(racingCars);
            RacingCar.display(racingCars);
            System.out.println();
        }
    }

}
