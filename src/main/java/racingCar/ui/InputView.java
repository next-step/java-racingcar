package racingCar.ui;

import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);

    public int inputCarNumbers() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public int inputTryTimes() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}