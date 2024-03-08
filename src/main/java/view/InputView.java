package view;

import java.util.Scanner;

public class InputView {

    public int inputRacingCarNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int inputTryNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
