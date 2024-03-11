package racing.view;

import racing.Constant;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int getNumberOfCars() {
        System.out.println(Constant.CMD_HOW_MANY_CAR);
        return scanner.nextInt();
    }

    public int getNumberOfChances() {
        System.out.println(Constant.CMD_HOW_MANY_CHANCE);
        return scanner.nextInt();
    }

    public void closeScanner() {
        scanner.close();
    }
}
