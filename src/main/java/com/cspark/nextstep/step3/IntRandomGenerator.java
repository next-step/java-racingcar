package com.cspark.nextstep.step3;

import java.util.Random;

public class IntRandomGenerator {
    private static Random random = new Random();

    public int generate(int min, int max) {
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }
}
