package study.racing.utils;

import study.racing.model.Car;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingUtils {
    private static final int MAX_RANDOM_NUM = 10;

    private static Random random = new Random();

    public static int getRandomNumber() {
        return random.nextInt(MAX_RANDOM_NUM);
    }
}
