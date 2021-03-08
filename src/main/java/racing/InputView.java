package racing;

import java.util.Scanner;

public class InputView extends View<RacingData, Void> {
    final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public RacingData show(Void data) {
        System.out.println("자동차 대수는 몇 대인가요?");
        int carsCount = scanner.nextInt();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int attemptsCount = scanner.nextInt();

        return new RacingData(carsCount, attemptsCount);
    }
}
