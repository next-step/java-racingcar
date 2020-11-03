package racingcar.car;

import racingcar.strategy.MoveStrategy;

import java.util.Random;

public class RacingCar implements Car {
    private int progress;
    private final String name;
    private final MoveStrategy moveStrategy;
    private static final Random random = new Random();

    public RacingCar(MoveStrategy strategy) {
        this(strategy, null);
    }

    public RacingCar(String name) {
        this(MoveStrategy.defaultStrategy(random), name);
    }

    public RacingCar(MoveStrategy moveStrategy, String name) {
        this.name = name;
        progress = 0;
        this.moveStrategy = moveStrategy;
    }

    public String getName() {
        return name;
    }


    @Override
    public void go() {
        if (allowMove()) {
            move();
        }
    }

    private void move() {
        progress ++;
    }

    @Override
    public boolean allowMove() {
        return moveStrategy.strategy();
    }

    @Override
    public int currentProgress() {
        return progress;
    }
}
