package step3;

import java.util.Random;

public class RamdomCondition {
    private static final int RANDOM_NUMBER_BOUND = 10;

    private Random ramdom;

    public RamdomCondition() {
        ramdom = new Random();
    }

    public boolean meet(int compare) {
        return ramdom.nextInt(RANDOM_NUMBER_BOUND) > compare;
    }
}
