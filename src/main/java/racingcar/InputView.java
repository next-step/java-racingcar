package racingcar;

import java.util.Scanner;

public class InputView {
    public RacingGame input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차는 몇 대인가요?");
        int cars = scanner.nextInt();
        System.out.println("몇 번 시도하나요?");
        int attempts = scanner.nextInt();

        return new RacingGame(cars, attempts);
    }
}
