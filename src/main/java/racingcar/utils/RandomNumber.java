package racingcar.utils;

import racingcar.command.NumberType;

import java.util.Random;

public class RandomNumber {

    private static Random random = new Random();

    public static int random() {
        return random.nextInt(NumberType.TEN.value());
    }

}
