package edu.nextstep.camp.racing.domain;

public class RacingStarter {


    public RacingStarter(RacingInfoFactory racingInfoFactory) {
        this.racingInfoFactory = racingInfoFactory;
    }

    private final RacingInfoFactory racingInfoFactory;

    public void start() {
        RacingInfo racingInfo = racingInfoFactory.createRacingInfo();

        new RacingGame(racingInfo).startGame();
    }
}
