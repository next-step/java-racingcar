package step3;

import java.util.Scanner;

public class InputView {

    private int carCount;
    private int inputTime;
    private Scanner scanner;

    public InputView(Scanner scan){
        scanner = scan;
    }

    public void getUserInput() {

        System.out.println("자동차 대수는 몇 대 인가요?");
        carCount = this.scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        inputTime = this.scanner.nextInt();

        if (carCount < 1) {
            throw new IllegalArgumentException("자동차 수가 0보다 작을 수 없습니다.");
        }

        if (inputTime < 1) {
            throw new IllegalArgumentException("반복횟수가 0보다 작을 수 없습니다.");
        }
    }

    public int getCarCount() {
        return carCount;
    }

    public int getInputTime() {
        return inputTime;
    }
}
