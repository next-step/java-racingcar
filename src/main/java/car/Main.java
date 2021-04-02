package car;

import car.controller.RacingCarController;
import car.domain.RacingCars;

public class Main {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController();
        RacingCars racingCars = new RacingCars();
        racingCarController.play(racingCars);
    }
}
