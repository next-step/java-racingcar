package racingcar.ui;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }


    public String getEnterCars() {
        return scanner.next();
    }
}
