package racing.testutil;

import java.util.Random;

public class DeterministicHighRandom extends Random {
    @Override
    public int nextInt(int bound){
        return 5;
    }
}
