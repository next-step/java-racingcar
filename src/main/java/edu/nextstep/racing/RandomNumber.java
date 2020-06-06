package edu.nextstep.racing;

import java.util.Random;

public class RandomNumber {
    Random random;

    RandomNumber() {
        random = new Random();
    }
    public int generator() {
        return random.nextInt(10);
    }
}
