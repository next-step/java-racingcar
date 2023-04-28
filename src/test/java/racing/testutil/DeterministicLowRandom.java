package racing.testutil;

import java.util.Random;

public class DeterministicLowRandom extends Random {
    @Override
    public int nextInt(int bound){
        return 0;
    }
}
