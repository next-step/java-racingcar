package step5.strategy;

import step5.Constant;

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


}
