package race;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public void printCar() {
        System.out.println("자동차 대수는 몇 대인가요?");
    }

    public int inputCar() {
        return scanner.nextInt();
    }

    public void printTry() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public int inputTry() {
        return scanner.nextInt();
    }
}
