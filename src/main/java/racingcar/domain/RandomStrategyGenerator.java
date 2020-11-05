package racingcar.domain;

import java.util.Random;

public class RandomStrategyGenerator implements StrategyGenerator{
    private static final int MAX_BOUNDARY = 10;
    private static final int THRESHOLD = 3;
    private static final Random random = new Random();

    public MoveStrategy generate(){
        if(random.nextInt(MAX_BOUNDARY) > THRESHOLD)
            return new ForwardStrategy();

        return new StopStrategy();
    }
}
