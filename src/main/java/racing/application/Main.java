package racing.application;

import racing.controller.RacingController;
import racing.dto.CarRaceDto;

public class Main {

    public static void main(String[] args) {
        RacingController racingController = new RacingController();

        CarRaceDto carRaceDto = racingController.makeCars();

        racingController.racingGame(carRaceDto);
    }
}
