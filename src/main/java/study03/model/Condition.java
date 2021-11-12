package study03.model;

import java.util.Random;

/*
 *
 * Condition
 *
 * @version 1.0.0
 *
 * 2021-11-10
 *
 * Copyright tnals1422
 */
public class Condition {

    private static final int LIMIT = 10;

    public static int generate() {
        return new Random().nextInt(LIMIT);
    }
}
