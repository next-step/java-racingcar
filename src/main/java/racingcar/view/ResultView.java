package racingcar.view;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String NEW_LINE = "\n";
    private static final String POSITION_MARK = "-";
    private static final String CAR_POSITION_IS = ":";
    private static final String COMMA = ",";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    private static int maxValue = Integer.MIN_VALUE;

    public static void printResultMessage() {
        System.out.println(NEW_LINE + RESULT_MESSAGE);
    }

    public static void printResult(final List<Car> cars) {
        cars.forEach(car -> System.out.println(printPosition(car)));
        System.out.println();
    }

    static String printPosition(final Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        String carName = car.getCarName();
        stringBuilder.append(carName).append(CAR_POSITION_IS);
        for (int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append(POSITION_MARK);
        }
        return stringBuilder.toString();
    }

    public static void getMaxValue(List<Car> cars) {
        for (Car car : cars) {
            findMaxValue(car);
        }
    }

    private static void findMaxValue(Car car) {
        if (car.getPosition() > maxValue) {
            maxValue = car.getPosition();
        }
    }

    private static List<String> getWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            findWinners(car, winners);
        }
        return winners;
    }

    private static void findWinners(Car car, List<String> winners) {
        if (car.getPosition() == maxValue) {
            winners.add(car.getCarName());
        }
    }

    private static String printWinner(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        getMaxValue(cars);
        List<String> winners = getWinners(cars);

        for (int i = 0; i < winners.size() - 1; i++) {
            String winnerName = winners.get(i);
            stringBuilder.append(winnerName).append(COMMA);
        }

        String lastWinnerName = winners.get(winners.size() - 1);
        stringBuilder.append(lastWinnerName);
        stringBuilder.append(WINNER_MESSAGE);
        return stringBuilder.toString();
    }

    public static void printWinnerResult(List<Car> cars) {
        System.out.println(printWinner(cars));
    }
}
