package racing.application;

import racing.domain.*;

public class RacingService {

    private final Moveable moveable;

    private final CarFactory carFactory;


    public RacingService(final Moveable moveable, final CarFactory carFactory) {
        this.carFactory = carFactory;
        this.moveable = moveable;
    }

    public GameReport play(final String carNames, final int round) {
        RacingGame racingGame = new RacingGame(moveable);
        Cars cars = carFactory.create(carNames);
        return racingGame.play(round, cars);
    }
}
