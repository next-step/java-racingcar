package racing.model;

import java.util.Random;

/*
 *
 * Condition
 *
 * @version 1.0.0
 *
 * 2021-11-12
 *
 * Copyright tnals1422
 */
public class Condition {

    private static final int LIMIT = 10;
    private static final Random RANDOM = new Random();

    public static int generate() {
        return RANDOM.nextInt(LIMIT);
    }
}
