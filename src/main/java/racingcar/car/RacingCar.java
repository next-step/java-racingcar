package racingcar.car;

import racingcar.strategy.MoveStrategy;

public class RacingCar implements Car {
    private int progress;
    private final String name;

    public RacingCar(String name) {
        this.name = name;
        progress = 0;
    }

    public String getName() {
        return name;
    }


    @Override
    public void go(MoveStrategy strategy) {
        if (allowMove(strategy)) {
            move();
        }
    }

    private void move() {
        progress ++;
    }

    @Override
    public boolean allowMove(MoveStrategy strategy) {
        return strategy.strategy();
    }

    @Override
    public int currentProgress() {
        return progress;
    }
}
