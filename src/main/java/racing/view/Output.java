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
        System.out.print("\n" + RESULT_MESSAGE);
    }

    public static void printWinMessage(List<String> winnerList) {
        System.out.print( WIN_MESSAGE);

        int lastMemberIndexOfRequiringSeparator = winnerList.size() - 2;
        int lastMemberIndexOfNotRequiringSeparator = lastMemberIndexOfRequiringSeparator + 1;
        StringBuilder winMessageStringBuilder = new StringBuilder();

        for (int i = 0; i <= lastMemberIndexOfRequiringSeparator; i++) {
            winMessageStringBuilder.append(winnerList.get(i));
            winMessageStringBuilder.append(WINNER_SEPARATOR);
            System.out.print(winMessageStringBuilder);
            winMessageStringBuilder.setLength(BUILDER_INIT_NUMBER);
        }
        System.out.println(winnerList.get(lastMemberIndexOfNotRequiringSeparator));
    }

    public static void printNowDistance(List<Car> carList) {
        System.out.println();
        StringBuilder distanceStringBuilder = new StringBuilder();
        for (Car car : carList) {
            distanceStringBuilder.append(car.getName());
            distanceStringBuilder.append(DISTANCE_SEPARATOR);
            distanceStringBuilder.append(printLoadConstant(car.getMoveCount()));
            distanceStringBuilder.append(System.lineSeparator());
        }
        System.out.println(distanceStringBuilder);
    }

    private static StringBuilder printLoadConstant(int moveCount) {
        StringBuilder loadStringBuilder = new StringBuilder();
        for (int j = 0; j < moveCount; j++) {
            loadStringBuilder.append(LOAD);
        }
        return loadStringBuilder;
    }
}
