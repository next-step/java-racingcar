package step3.view;

import java.util.Scanner;

public class InputView {

    Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int inputCar() {
         System.out.println("자동차 대수는 몇 대 인가요?");
         return scanner.nextInt();
    }

    public int inputAttempt() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

}
