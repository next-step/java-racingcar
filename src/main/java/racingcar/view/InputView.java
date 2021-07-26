package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String ROUNDS = "시도할 회수는 몇 회 인가요?";
    public static final String NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    public static int askForNumberOfRounds() {
        System.out.println(ROUNDS);
        return scanner.nextInt();
    }

    public static String askForCarNames() {
        System.out.println(NAMES);
        return scanner.nextLine();
    }
}
