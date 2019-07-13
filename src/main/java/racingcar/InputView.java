package racingcar;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_MESSAGE_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_MESSAGE_COUNTS = "시도할 횟수는 몇 회 인가요?";
    static Scanner scanner = new Scanner(System.in);

    public static String inputNamesOfCars() {
        System.out.println(INPUT_MESSAGE_NAMES);
        return scanner.nextLine();
    }

    public static int inputNumberOfGames() {
        System.out.println(INPUT_MESSAGE_COUNTS);
        return scanner.nextInt();
    }
}
