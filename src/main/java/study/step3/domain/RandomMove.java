package study.step3.domain;

import java.util.Random;

public class RandomMove implements MoveStrategy{

    private static final Random random = new Random();

    @Override
    public int createMove() {
        return random.nextInt(10);
    }
}
