package step5.controller;

import step5.service.RacingGameService;
import step5.service.RacingWinner;

public class RacingGameController {

    private final RacingGameService racingGame;
    private final RacingWinner racingWinner;

    public RacingGameController(){
        this.racingGame = new RacingGameService();
        this.racingWinner = new RacingWinner();
    }

    public static void start(){

    }
}
