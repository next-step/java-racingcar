package racingGame;

import java.util.Random;

public class ScoreGenerator {

    private static final int THRESH_HOLD = 4;
    private static final int GO = 1;
    private static final int STAY = 0;

    private final Random rawValueGenerator;

    public ScoreGenerator() {
        this.rawValueGenerator = new Random();
    }

    public ScoreGenerator(long seed){
        this();
        rawValueGenerator.setSeed(seed);
    }

    public int generateScore() {
        return rawValueGenerator.nextInt(10) > THRESH_HOLD ? GO : STAY;
    }
}
