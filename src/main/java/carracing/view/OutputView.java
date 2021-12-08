package carracing.view;

import carracing.domain.Car;
import carracing.domain.CarPosition;
import carracing.domain.Cars;
import carracing.domain.CarsGroup;

import java.util.stream.Collectors;

/**
 * 자동차 경주 현황을 출력하기 위한 콘솔
 */
public class OutputView {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String POSITION_NOTATION = "-";
    private static final String WINNER_RESULT_MESSAGE = "가 최종 우승했습니다.";

    public static void printResultOfRacingGame(CarsGroup carsGroup) {
        carsGroup.getCarsGroup()
                .forEach(OutputView::printStatusOfRacing);
        printWinningCarsOfRacing(carsGroup.lastCars());
    }

    public static void printStatusOfRacing(Cars cars) {
        cars.getCars()
                .forEach(car -> System.out.println(statusOfCar(car)));
        System.out.println();
    }

    public static void printWinningCarsOfRacing(Cars cars) {
        String winningCars = cars.retrieveWinningCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winningCars + WINNER_RESULT_MESSAGE);
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    private static String statusOfCar(Car car) {
        return String.format("%s : %s", car.getName(), notationOfpositionOfCar(car.getPosition()));
    }

    private static String notationOfpositionOfCar(CarPosition carPosition) {
        int positionNumber = carPosition.getNumber();
        StringBuilder positionNotation = new StringBuilder(positionNumber);
        for (int i = 0; i < positionNumber; i++) {
            positionNotation.append(POSITION_NOTATION);
        }
        return positionNotation.toString();
    }
}
