package study.racingcar;

import java.util.Scanner;

public class InputView {
    private int inputInteger() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return number;
    }

    public int inputCar() {
        int number;

        do {
            System.out.println("자동차 대수는 몇 대 인가요? (1 이상)");
            number = inputInteger();
        } while (number < 1);

        return number;
    }

    public int inputRound() {
        int number;

        do {
            System.out.println("시도할 회수는 몇 회 인가요? (1 이상)");
            number = inputInteger();
        } while (number < 1);

        return number;
    }
}
