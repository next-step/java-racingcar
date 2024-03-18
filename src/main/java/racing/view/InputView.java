package racing.view;

import racing.Constant;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String getNamesOfCars() {
        System.out.println(Constant.CMD_NANE_OF_CARS);
        return scanner.nextLine();
    }

    public int getNumberOfRounds() {
        System.out.println(Constant.CMD_HOW_MANY_CHANCE);
        return scanner.nextInt();
    }
}
