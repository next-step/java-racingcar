package race.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public int inputCar() {
        System.out.println("자동차 대수는 몇 대인가요?");
        return scanner.nextInt();
    }

    public int inputTry() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextInt();
    }
}
