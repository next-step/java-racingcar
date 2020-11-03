package humbledude.carracing;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int getNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public int getNumberOfTurns() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
