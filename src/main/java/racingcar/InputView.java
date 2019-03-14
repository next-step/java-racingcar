package racingcar;

import java.util.Scanner;

public class InputView {
    public static int getCarNo() {
        System.out.println("자동차 대수는 몇대인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int getTryNo() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
