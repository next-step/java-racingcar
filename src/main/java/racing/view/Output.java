package racing.view;

import racing.Car;

import java.util.List;

public class Output {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.";
    private static final String INPUT_COUNT_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WIN_MESSAGE = "최종 우승자: ";
    private static final String LOAD = "-";
    private static final String WINNER_SEPARATOR = ", ";
    private static final String DISTANCE_SEPARATOR = " : ";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printInputCountMessage() {
        System.out.println(INPUT_COUNT_MESSAGE);
    }

    public static void printResultMessage() {
        System.out.println("\n" + RESULT_MESSAGE);
    }

    public static void printWinMessage(List<String> winnerList) {
        System.out.print("\n" + WIN_MESSAGE);

        int memberIndexOfRequiringSeparator = winnerList.size() -2;
        int memberIndexOfNotRequiringSeparator = memberIndexOfRequiringSeparator + 1;

        for (int i = 0; i <= memberIndexOfRequiringSeparator; i++) {
            System.out.print(winnerList.get(i) + WINNER_SEPARATOR);
        }
        System.out.println(winnerList.get(memberIndexOfNotRequiringSeparator));
    }

    public static void printNowDistance(List<Car> carList) {
        System.out.println();
        for (int i = 0; i < carList.size(); i++) {
            System.out.print(carList.get(i).getName() + DISTANCE_SEPARATOR);
            printLoadConstant(carList.get(i).getMoveCount());
            System.out.println();
        }
    }

    private static void printLoadConstant(int gameRepeatCount) {
        for (int j = 0; j < gameRepeatCount; j++) {
            System.out.print(LOAD);
        }
    }
}
