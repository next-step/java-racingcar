package carRacing;

import carRacing.controller.RacingCarWinnersManager;

public class RacingCarWinnersApplication {
    public static void main(String[] args) {
        RacingCarWinnersManager gameRun = new RacingCarWinnersManager();
        gameRun.raceWinner();
    }
}
