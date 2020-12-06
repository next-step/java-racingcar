package carracing.console;

import carracing.domain.Car;
import carracing.domain.CarPosition;
import carracing.domain.Cars;

/**
 * 자동차 경주 현황을 출력하기위한 콘솔
 */
public class OutputConsole {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String POSITION_NOTATION = "-";

    private OutputConsole() {
    }

    public static void printStatusOfRacing(Cars cars) {
        cars.getCars()
                .stream()
                .map(Car::getPosition)
                .forEach(carPosition -> System.out.println(convertStatusOfCar(carPosition)));
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    private static String convertStatusOfCar(CarPosition carPosition) {
        int positionNumber = carPosition.getNumber();
        StringBuilder positionNotation = new StringBuilder(positionNumber);
        for (int i = 0; i < positionNumber; i++) {
            positionNotation.append(POSITION_NOTATION);
        }
        return positionNotation.toString();
    }
}
