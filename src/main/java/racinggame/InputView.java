package racinggame;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int inputNumberOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return inputPositiveInt();
    }

    public int inputTryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return inputPositiveInt();
    }

    private int inputPositiveInt() {
        int num = scanner.nextInt();
        if (num <= 0) {
            throw new RuntimeException("0 또는 음수는 전달할 수 없습니다.");
        }
        return num;
    }

}
