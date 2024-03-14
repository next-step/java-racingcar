package carRacingWinner;

import carRacingWinner.controller.WinnerRacingController;
import carRacingWinner.repository.WinnerRepository;
import carRacingWinner.service.WinnerService;

public class RacingWinnerApplication {

    public static void main(String[] args) {

        WinnerRepository winnerRepository = new WinnerRepository();
        WinnerService winnerService = new WinnerService(winnerRepository);

        new WinnerRacingController(winnerService).racingStart();
    }
}
