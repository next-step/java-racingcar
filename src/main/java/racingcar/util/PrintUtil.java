package racingcar.util;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Winners;
import racingcar.model.enums.Status;
import racingcar.model.wrapper.CarName;

import java.util.stream.Collectors;

import static racingcar.model.enums.Status.FORWARD;

public class PrintUtil {
    public static final String LINE_BREAK = "\n";
    public static final String DASH = "-";
    public static final String EMPTY_STRING = "";
    public static final String COLON = " : ";
    public static final String FINAL_WINNER_POSTFIX = "가 최종 우승했습니다.";
    public static final String COMMA = ", ";

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
        String name = car.carName()
                .name();
        String currentStatus = car.currentStatus()
                .stream()
                .map(PrintUtil::convertPrintForwardStatus)
                .collect(Collectors.joining());
        return name + COLON + currentStatus;
    }

    private static String convertPrintForwardStatus(Status status) {
        if (FORWARD.equals(status)) {
            return DASH;
        }
        return EMPTY_STRING;
    }

    public static String winners(Winners winner) {
        return winner.result()
                .stream()
                .map(CarName::name)
                .collect(Collectors.joining(COMMA)) +
                FINAL_WINNER_POSTFIX;
    }
}
