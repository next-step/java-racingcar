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

    private OutputView() {
        throw new AssertionError();
    }

    public static void printResultOfRacingGame(CarsGroup carsGroup) {
        System.out.println(resultAllStatusOfCars(carsGroup));
    }

    private static String resultAllStatusOfCars(CarsGroup carsGroup) {
        return String.format("%n%s%n%s %n%n%s", RESULT_MESSAGE, allStatusOfCars(carsGroup), resultOfWinningCars(carsGroup.lastCars()));
    }

    private static String allStatusOfCars(CarsGroup carsGroup) {
        return carsGroup.getCarsGroup()
                .stream()
                .map(OutputView::statusOfCars)
                .collect(Collectors.joining("\n\n"));
    }

    private static String resultOfWinningCars(Cars cars) {
        return String.format("%s%s", winningCars(cars), WINNER_RESULT_MESSAGE);
    }

    private static String statusOfCars(Cars cars) {
        return cars.getCars()
                .stream()
                .map(OutputView::statusOfCar)
                .collect(Collectors.joining("\n"));
    }

    private static String winningCars(Cars cars) {
        return cars.retrieveWinningCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private static String statusOfCar(Car car) {
        return String.format("%s : %s", car.getName(), notationOfPositionOfCar(car.getPosition()));
    }

    private static String notationOfPositionOfCar(CarPosition carPosition) {
        int positionNumber = carPosition.getNumber();
        StringBuilder positionNotation = new StringBuilder(positionNumber);
        for (int i = 0; i < positionNumber; i++) {
            positionNotation.append(POSITION_NOTATION);
        }
        return positionNotation.toString();
    }
}
