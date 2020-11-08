package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String NEW_LINE = "\n";
    private static final String POSITION_MARK = "-";
    private static final String CAR_POSITION_IS = ":";
    private static final String COMMA = ",";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void printResultMessage() {
        System.out.println(NEW_LINE + RESULT_MESSAGE);
    }

    public static void printPositionResult(List<Car> cars) {
        cars.forEach(car -> System.out.println(printPosition(car)));
        System.out.println();
    }

    static String printPosition(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        String carName = car.getCarName();
        stringBuilder.append(carName).append(CAR_POSITION_IS);
        for (int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append(POSITION_MARK);
        }
        return stringBuilder.toString();
    }

    static String getNamesOfWinnerCarsInString(List<Car> winnerCars) {
        return winnerCars.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(COMMA));
    }

    public static void printNamesOfWinnerCarsResult(List<Car> winnerCars) {
        String winner = getNamesOfWinnerCarsInString(winnerCars) + WINNER_MESSAGE;
        System.out.println(winner);
    }
}