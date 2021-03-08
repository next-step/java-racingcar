package racingcar.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public int inputNumber() {
        return scanner.nextInt();
    }

    public int inputCarCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return inputNumber();
    }

    public int inputNumberOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return inputNumber();
    }
}
