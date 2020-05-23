package step3;

import java.util.Scanner;

public class InputView {

    private int carCount;
    private int inputTime;

    public void scanner() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        carCount = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        inputTime = scanner.nextInt();

        if (carCount < 1 || inputTime < 1) {
            throw new IllegalArgumentException("입력값이 0보다 작을 수 없습니다.");
        }
    }

    public int getCarCount() {
        return this.carCount;
    }

    public int getInputTime() {
        return this.inputTime;
    }
}
