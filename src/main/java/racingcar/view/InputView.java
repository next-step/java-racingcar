package racingcar.view;

import racingcar.domain.Car;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int inputCountOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");

        return scanner.nextInt();
    }

    public int inputCountOfPlay() {
        System.out.println("시도할 회수는 몇 회 인가요?");

        return scanner.nextInt();
    }
}
