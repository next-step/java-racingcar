package racingcar.strategy;

import racingcar.Constant;

import java.util.Random;

@FunctionalInterface
public interface MoveStrategy {
    boolean strategy();

    default boolean strategy(int number) {
        return true;
    }

    static MoveStrategy defaultStrategy(Random random){
        return ()->random.nextInt(Constant.RANDOM_MAX_NUMBER) > Constant.ANCHOR_POINT;
    }

    static MoveStrategy unconditionalForwardStrategy(){
        return ()->true;
    }
    static MoveStrategy unconditionalStopStrategt(){
        return ()->false;
    }
}
