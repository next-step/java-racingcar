package racingcar.util;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

public class StringUtil {

    private final static String DELIMITER = ",";
    private final static String STATE = "-";

    public static List<String> splitString(String s) {
        return Arrays.asList(s.split(DELIMITER));
    }

    public static String makeStateLine(Integer r) {
        return String.valueOf(new char[r])
                .replace("\0", STATE);
    }

    public static String printName(List<Car> winner) {
        StringBuilder winners = new StringBuilder();
        for (Car car : winner) {
            winners.append(car.getName()).append(", ");
        }
        return winners.substring(0, winners.length() -2);
    }
}
