package step3.car;

import step3.strategy.MoveStrategy;
import step3.strategy.PrintMarkStrategy;

import java.util.Random;

public class RacingCar implements Car {
    private int progress;
    private final MoveStrategy moveStrategy;
    private static final Random random = new Random();

    public RacingCar() {
        moveStrategy = MoveStrategy.defaultStrategy(random);
        progress = 0;
    }

    public RacingCar(MoveStrategy moveStrategy) {
        progress = 0;
        this.moveStrategy = moveStrategy;
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
