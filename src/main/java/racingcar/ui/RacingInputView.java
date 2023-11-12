package racingcar.ui;

import java.util.Scanner;

public class RacingInputView {

    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static int raceTimes() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public static String carsName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }
}
