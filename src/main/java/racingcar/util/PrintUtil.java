package racingcar.util;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.enums.Status;

import java.util.stream.Collectors;

import static racingcar.model.enums.Status.FORWARD;

public class PrintUtil {
    public static final String LINE_BREAK = "\n";
    public static final String DASH = "-";
    public static final String EMPTY_STRING = "";

    public static String result(Cars cars) {
        return carsStatuses(cars) + LINE_BREAK;
    }

    private static String carsStatuses(Cars cars) {
        return cars.currentCars()
                .stream()
                .map(PrintUtil::carStatus)
                .collect(Collectors.joining(LINE_BREAK)) + LINE_BREAK;
    }

    private static String carStatus(Car car) {
        return car.currentStatus()
                .stream()
                .map(PrintUtil::convertPrintForwardStatus)
                .collect(Collectors.joining());
    }

    private static String convertPrintForwardStatus(Status status) {
        if (FORWARD.equals(status)) {
            return DASH;
        }
        return EMPTY_STRING;
    }

}
