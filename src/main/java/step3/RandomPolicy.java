package step3;

import java.util.Random;

public class RandomPolicy implements Policy {

    private final static Random random = new Random();

    @Override
    public int apply(int position) {
        if (random.nextInt(10) >= 4) {
            return position += 1;
        }
        return position;
    }
}
