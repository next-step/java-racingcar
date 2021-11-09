package study03;

import java.util.Random;

/*
 *
 * ConditionGenerator
 *
 * @version 1.0.0
 *
 * 2021-11-10
 *
 * Copyright tnals1422
 */
public class ConditionGenerator {

    public static int generate() {
        return new Random().nextInt(10);
    }
}
