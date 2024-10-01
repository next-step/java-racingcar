package racingcar.util;

import racingcar.model.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class PrintUtil {
    public static final String LINE_BREAK = "\n";

    public static String result(Cars cars) {
        return String.join(LINE_BREAK, cars.currentStatuses()) +
                LINE_BREAK +
                LINE_BREAK;
    }

}
