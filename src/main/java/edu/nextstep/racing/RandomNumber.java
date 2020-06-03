package edu.nextstep.racing;

import java.util.Random;

public class RandomNumber {
    public int generator() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
