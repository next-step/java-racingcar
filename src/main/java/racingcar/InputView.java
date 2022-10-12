package racingcar;

import java.util.Scanner;

public class InputView {
    private static final String QUERY_LIST_OF_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUERY_NUMBER_OF_TRIALS_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String SEPARATOR = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] queryListOfCarNames() {
        System.out.println(QUERY_LIST_OF_CAR_NAMES_MESSAGE);
        return splitLine(inputString());
    }

    private static String[] splitLine(String line) {
        return line.split(SEPARATOR);
    }

    public static int queryNumberOfTrials() {
        System.out.println(QUERY_NUMBER_OF_TRIALS_MESSAGE);
        return inputNumber();
    }

    private static int inputNumber() {
        return scanner.nextInt();
    }

    private static String inputString() {
        return scanner.nextLine();
    }
}
