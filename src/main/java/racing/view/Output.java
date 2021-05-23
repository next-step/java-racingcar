package racing.view;

import racing.domain.Car;

import java.util.List;

public class Output {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.";
    private static final String INPUT_COUNT_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WIN_MESSAGE = "최종 우승자: ";
    private static final String LOAD = "-";
    private static final String WINNER_SEPARATOR = ", ";
    private static final String DISTANCE_SEPARATOR = " : ";
    private static final int BUILDER_INIT_NUMBER = 0;

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

        int lastMemberIndexOfRequiringSeparator = winnerList.size() - 2;
        int lastMemberIndexOfNotRequiringSeparator = lastMemberIndexOfRequiringSeparator + 1;
        StringBuilder winMessageStringBuilder = new StringBuilder();

        for (int i = 0; i <= lastMemberIndexOfRequiringSeparator; i++) {
            winMessageStringBuilder.append(winnerList.get(i).getName());
            winMessageStringBuilder.append(WINNER_SEPARATOR);
            System.out.print(winMessageStringBuilder);
            winMessageStringBuilder.setLength(BUILDER_INIT_NUMBER);
        }
        System.out.println(winnerList.get(lastMemberIndexOfNotRequiringSeparator).getName());
    }

    public static void printNowDistance(List<Car> carList) {
        StringBuilder distanceStringBuilder = new StringBuilder();
        for (Car car : carList) {
            distanceStringBuilder.append(car.getName());
            distanceStringBuilder.append(DISTANCE_SEPARATOR);
            StringBuilder loadBuilder = repeatAppendLoad(car.getMoveCount());
            distanceStringBuilder.append(loadBuilder);
            distanceStringBuilder.append(System.lineSeparator());
        }
        System.out.print(distanceStringBuilder);
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
            //이름 :
            distanceStringBuilder.append(car.getName());
            distanceStringBuilder.append(DISTANCE_SEPARATOR);
            // 0라운드 거리별 - 생성
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
