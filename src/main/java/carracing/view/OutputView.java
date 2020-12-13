package carracing.view;

import carracing.domain.Car;
import carracing.domain.CarName;
import carracing.domain.CarPosition;
import carracing.domain.CarGroup;

import java.util.stream.Collectors;

/**
 * 자동차 경주 현황을 출력하기위한 콘솔
 */
public class OutputView {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String POSITION_NOTATION = "-";
    private static final String WINNER_RESULT_MESSAGE = "가 최종 우승했습니다.";

    public static void printWinningCarsOfRacing(CarGroup carGroup) {
        String winningCars = carGroup.retrieveWinningCars()
                .stream()
                .map(Car::getName)
                .map(CarName::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winningCars + WINNER_RESULT_MESSAGE);
    }

    public static void printStatusOfRacing(CarGroup carGroup) {
        carGroup.getCars()
                .forEach(car -> System.out.println(convertStatusOfCar(car)));
        System.out.println();
    }

    private static String convertStatusOfCar(Car car) {
        String nameOfCar = car.getName().getName();
        String positionOfCar = convertPositionOfCar(car.getPosition());
        return nameOfCar + ":" + positionOfCar;
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    private static String convertPositionOfCar(CarPosition carPosition) {
        int positionNumber = carPosition.getNumber();
        StringBuilder positionNotation = new StringBuilder(positionNumber);
        for (int i = 0; i < positionNumber; i++) {
            positionNotation.append(POSITION_NOTATION);
        }
        return positionNotation.toString();
    }
}
