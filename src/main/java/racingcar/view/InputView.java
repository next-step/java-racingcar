package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        return inputLine();
    }

    public static int inputRounds() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return inputInt();
    }

    private static int inputInt() {
        return scanner.nextInt();
    }

    private static String inputLine() {
        return scanner.nextLine();
    }
}

