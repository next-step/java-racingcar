package step3;

import java.util.Random;

public class RandomRule implements Rule {

    private static final int MAX_NUMBER = 10;
    private static final int CONDITION_NUMBER = 4;


    private static final Random random = new Random();

    @Override
    public boolean apply() {
        if (random.nextInt(MAX_NUMBER) >= CONDITION_NUMBER) {
            return true;
        }
        return false;
    }
}
