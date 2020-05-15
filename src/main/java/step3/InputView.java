package step3;

import java.util.Scanner;

public class InputView {
    Scanner scanner;
    private int carCount;
    private int repeatCount;

    public void initInput() {
        scanner = new Scanner(System.in);
        askNumberCount();
        askRepeatCount();
    }

    private void askNumberCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        carCount = scanner.nextInt();
    }

    private void askRepeatCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        repeatCount = scanner.nextInt();
    }

    public int getCarCount() {
        return carCount;
    }

    public int getRepeatCount() {
        return repeatCount;
    }
}
