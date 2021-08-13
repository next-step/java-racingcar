package racingcar.view;

import java.util.Scanner;

public class InputView {
    public static int inputCar() {
        System.out.println("자동자 대수는 몇 대 인가요?");
        return new Scanner(System.in).nextInt();
    }

    public static int inputAttempt() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return new Scanner(System.in).nextInt();
    }
}
