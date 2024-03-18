package carRacingWinner;

import carRacingWinner.controller.WinnerRacingController;
import carRacingWinner.repository.WinnerRepository;
import carRacingWinner.service.WinnerService;

public class RacingWinnerApplication {

    public static void main(String[] args) {

        WinnerRacingController racing = new WinnerRacingController();
        racing.racingStart();

    }
}
