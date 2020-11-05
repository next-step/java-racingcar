package racingcar.domain;

import java.util.Random;

public class RandomStrategyGenerator {
    private static final int MAX_BOUNDARY = 10;
    private static final int THRESHOLD = 3;
    private static final Random random = new Random();

    private static RandomStrategyGenerator instance;

    private RandomStrategyGenerator(){}

    public static RandomStrategyGenerator getInstance(){
        if(instance == null)
            instance = new RandomStrategyGenerator();

        return instance;
    }

    public MoveStrategy generate(){
        if(random.nextInt(MAX_BOUNDARY) > THRESHOLD)
            return new ForwardStrategy();

        return new StopStrategy();
    }
}
