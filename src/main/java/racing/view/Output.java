package racing.view;

import racing.domain.Car;

import java.util.ArrayList;
import java.util.List;

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

    public static void printWinMessage(List<Car> winnerList) {
        System.out.print(WIN_MESSAGE);
        ArrayList winners = new ArrayList<>();

        for (int i = 0; i < winnerList.size(); i++) {
            winners.add(winnerList.get(i).getName());

        }
        System.out.println(String.join(", ", winners));
    }

    public static void printResultByMovedLog(List<Car> carList, int wholeRound) {
        StringBuilder resultStringBuilder = new StringBuilder();

        for (int round = 0; round < wholeRound; round++) {
            resultStringBuilder.append(makeDistanceBuilderByRound(carList, round));
            resultStringBuilder.append(System.lineSeparator());
        }
        System.out.print(resultStringBuilder);
    }

    private static StringBuilder makeDistanceBuilderByRound(List<Car> carList, int round) {
        StringBuilder distanceStringBuilder = new StringBuilder();

        for (Car car : carList) {
            distanceStringBuilder.append(car.getName());
            distanceStringBuilder.append(DISTANCE_SEPARATOR);
            StringBuilder loadBuilder = repeatAppendLoad(getMoveCountByRound(car, round));
            distanceStringBuilder.append(loadBuilder);
            distanceStringBuilder.append(System.lineSeparator());
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
        return car.getMovedLog().getMovedLogs().get(round);
    }
}
