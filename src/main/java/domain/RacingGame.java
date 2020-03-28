package domain;

import strategy.MovableStrategy;

public class RacingGame {

    public void playGame(Cars cars, MovableStrategy randomNumbers) {
        cars.moveAll(randomNumbers);
    }

}
