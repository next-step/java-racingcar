package edu.nextstep.racing.utils;

import edu.nextstep.racing.model.Car;
import edu.nextstep.racing.model.Cars;

import java.util.List;
import java.util.stream.Collectors;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-18 20:37
 */
public final class ViewUtils {

    private static final String DASH = "- ";
    private static final String COLON = " : ";
    private static final String COMMA = ",";

    public static void printMessage(String message) {
        ValidationUtils.checkStringArgument(message);
        System.out.println(message);
    }

    public static void combinDash(Car car, int combinCount) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getCarName());
        sb.append(COLON);

        for (int i = 0; i < combinCount; i++) {
            sb.append(DASH);
        }
        System.out.println(sb.toString());
    }

    public static void printWinner(Cars winner) {
        String win = winner.getCars().stream()
                .map(Car::getCarName)
                .collect(Collectors.toList())
                .stream()
                .reduce((s1, s2) -> s1 + COMMA + s2)
                .get();
        System.out.println(win);
    }

    public static void print() {
        System.out.println();
    }
}