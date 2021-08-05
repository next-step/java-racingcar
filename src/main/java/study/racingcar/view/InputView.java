package study.racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int enterNumberOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return enterNumber();
    }

    public static String enterNameOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        return enterName();
    }

    public static int enterNumberOfAttempt() {
        System.out.println("시도할 대수는 몇 회 인가요?");
        return enterNumber();
    }

    private static String enterName() {
        return SCANNER.nextLine();
    }

    private static int enterNumber() {
        return SCANNER.nextInt();
    }
}
