package RacingGame;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int countTime() {
        System.out.println("시도할 회수는 몇 회 인가요?\n");
        return scanner.nextInt();
    }

    public int countCar() {
        System.out.println("자동차 대수는 몇 대 인가요?\n");
        return scanner.nextInt();
    }
}
