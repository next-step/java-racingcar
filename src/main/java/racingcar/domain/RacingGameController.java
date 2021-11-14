package racingcar.domain;

public class RacingGameController {

    private static final RacingGameController GAME_CONTROLLER = new RacingGameController();

    private RacingGameController() {
    }

    public static RacingGameController getInstance() {
        return GAME_CONTROLLER;
    }

    public RacingCars race(RacingCars racingCars) {
        return racingCars.race();
    }
}
