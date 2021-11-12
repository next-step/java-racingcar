package racing;

import java.util.Random;

/**
 * @author han
 */
public class DeterministicRandom extends Random {
    int sequentialNum = 0;

    public DeterministicRandom() {
        super();
    }

    @Override
    public int nextInt(int input) {
        return sequentialNum++;
    }
}
