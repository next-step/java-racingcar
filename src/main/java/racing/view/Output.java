package racing.view;

import racing.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class Output {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.";
    private static final String INPUT_COUNT_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WIN_MESSAGE = "최종 우승자: ";
    private static final String LOAD = "-";
    private static final String DISTANCE_SEPARATOR = " : ";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printInputCountMessage() {
        System.out.println(INPUT_COUNT_MESSAGE);
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printResultByMovedLog(List<Car> cars, int wholeRound) {
        StringBuilder resultStringBuilder = new StringBuilder();

        for (int round = 0; round < wholeRound; round++) {
            resultStringBuilder.append(makeDistanceBuilderByRound(cars, round));
            resultStringBuilder.append(System.lineSeparator());
        }
        System.out.print(resultStringBuilder);
    }

    private static StringBuilder makeDistanceBuilderByRound(List<Car> cars, int round) {
        StringBuilder distanceStringBuilder = new StringBuilder();

        for (Car car : cars) {
            distanceStringBuilder.append(car.getName()).append(DISTANCE_SEPARATOR);
            StringBuilder loadBuilder = repeatAppendLoad(getMoveCountByRound(car, round));
            distanceStringBuilder.append(loadBuilder).append(System.lineSeparator());
        }

        return distanceStringBuilder;
    }

    private static StringBuilder repeatAppendLoad(int moveCount) {
        StringBuilder loadStringBuilder = makeLoadBuilder(moveCount);
        return loadStringBuilder;
    }

    private static StringBuilder makeLoadBuilder(int moveCount) {
        StringBuilder loadStringBuilder = new StringBuilder();

        for (int j = 0; j < moveCount; j++) {
            loadStringBuilder.append(LOAD);
        }

        return loadStringBuilder;
    }

    private static int getMoveCountByRound(Car car, int round) {
        return car.getMovedLogByRound(round);
    }

    public static void printWinMessage(List<Car> winners) {
        System.out.print(WIN_MESSAGE);
        System.out.println(winners.stream().map(Car::getName).collect(Collectors.joining(", ")));
    }
}
