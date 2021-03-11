package step3;

import java.util.Scanner;

public class InputView {
    private int carsCount;
    private int roundsCount;
    private Scanner scanner;

    public InputView() {
        carsCount = 0;
        roundsCount = 0;
        scanner = new Scanner(System.in);
    }

    public int getCarsCount() {
        return this.carsCount;
    }

    public int getRoundsCount() {
        return this.roundsCount;
    }

    public void inputCarsCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        carsCount = scanner.nextInt();
    }

    public void inputRoundsCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        roundsCount = scanner.nextInt();
    }
}
