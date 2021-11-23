package racing.model;

import java.util.Random;

/*
 *
 * ConditionGenerator
 *
 * @version 1.0.0
 *
 * 2021-11-23
 *
 * Copyright tnals1422
 */
public class ConditionGenerator {
    private static final int LIMIT = 10;
    private static final Random RANDOM = new Random();

    public static int generate() {
        return RANDOM.nextInt(LIMIT);
    }
}
