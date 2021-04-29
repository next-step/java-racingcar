package ugemang.nextstep.service;

import ugemang.nextstep.domain.car.Winner;

public class RacingGame {
    private final RacingGameService racingGameService;

    public RacingGame(RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    public void run(){
        racingGameService.inputGameInformation();
        racingGameService.start();
    }

    public void getWinner(){
        Winner winner = racingGameService.getWinner();
        racingGameService.print(winner.toStringBuffer());
    }
}
