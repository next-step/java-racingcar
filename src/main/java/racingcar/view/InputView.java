package racingcar.view;

import java.util.Scanner;

public class InputView {

    private InputView() {}

    public final static Scanner scanner = new Scanner(System.in);

    public static int nextInt() {
        return scanner.nextInt();
    }

    public static String nextString() {
        return scanner.nextLine();
    }

    public static void askTryCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public static void askCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }
}
