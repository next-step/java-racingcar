package racing.view;

import racing.Constant;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getNumberOfCars() {
        System.out.println(Constant.CMD_HOW_MANY_CAR);
        return scanner.nextInt();
    }

    public int getNumberOfRounds() {
        System.out.println(Constant.CMD_HOW_MANY_CHANCE);
        return scanner.nextInt();
    }
}
