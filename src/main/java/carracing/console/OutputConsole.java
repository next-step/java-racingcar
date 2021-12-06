package carracing.console;

import carracing.domain.Car;
import carracing.domain.CarPosition;
import carracing.domain.Cars;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * 자동차 경주 현황을 출력하기 위한 콘솔
 */
public class OutputConsole {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String POSITION_NOTATION = "-";
    private static final String WINNER_RESULT_MESSAGE = "가 최종 우승했습니다.";

    public static void printResultOfRacingGame(List<Cars> carsGroup) {
        carsGroup.forEach(OutputConsole::printStatusOfRacing);
        printWinningCarsOfRacing(lastCars(carsGroup));
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

    private static Cars lastCars(List<Cars> carsGroup) {
        return carsGroup.stream()
                .skip(Math.min(carsGroup.size(), 1))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("last Cars is not found."));
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
