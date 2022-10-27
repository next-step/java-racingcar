package step3;

import java.util.Random;

public class RandomBounded {

    private int random;

    public RandomBounded() {
        random = new Random().nextInt(10);
    }

    /* for test */
    public RandomBounded(int input) {
        random = input;
    }

    public boolean moreThan4() {
        return random >= 4;
    }

}
