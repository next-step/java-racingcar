package step5.view;

import java.util.List;
import java.util.Scanner;

public class View {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String MESSAGE_TO_GET_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MESSAGE_TO_GET_TRY_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final String MESSAGE_FOR_WRONG_TRY_COUNT = "시도 횟수는 1보다 작을 수 없습니다.";
    private static final String MESSAGE_FOR_START = "실행 결과";
    private static final String MESSAGE_FOR_RESULT = "가 최종 우승했습니다.";

    public static String getNameOfCars() {
        System.out.println(MESSAGE_TO_GET_NAMES);
        return scanner.nextLine();
    }

    public static int getTryCount() {
        System.out.println(MESSAGE_TO_GET_TRY_COUNT);
        int tryCount = scanner.nextInt();
        if (tryCount <= 0) {
            throw new IllegalArgumentException(MESSAGE_FOR_WRONG_TRY_COUNT);
        }
        return tryCount;
    }

    public static void newLine() {
        System.out.println();
    }

    public static void printStart() {
        newLine();
        System.out.println(MESSAGE_FOR_START);
    }

    public static void printEachResult(List<String> results) {
        for (String result : results) {
            System.out.println(result);
        }
        newLine();
    }

    public static void printWinner(List<String> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        String joinedName = String.join(", ", winners);
        stringBuilder.append(joinedName);
        stringBuilder.append(MESSAGE_FOR_RESULT);
        System.out.println(stringBuilder);
    }

}
