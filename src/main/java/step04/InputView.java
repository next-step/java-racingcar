package step04;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    final static String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    final static String INPUT_NUMBER_OF_MOVES_MESSAGE = "시도할 회수는 몇회인가요?";
    static final String delimiter = ",";

    public static String[] readCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return scanner.nextLine().split(delimiter);
    }

    public static int readNumberOfMoves() {
        System.out.print(INPUT_NUMBER_OF_MOVES_MESSAGE);
        return scanner.nextInt();
    }
}
