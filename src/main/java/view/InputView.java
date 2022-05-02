package view;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public String getCarNames() {
        return scanner.nextLine();
    }

    public int getNumberOfRounds() {
        return scanner.nextInt();
    }
}
