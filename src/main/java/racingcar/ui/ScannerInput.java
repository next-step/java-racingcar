package racingcar.ui;

import java.util.Scanner;

public class ScannerInput extends RacingDataInput {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String inputNames() {
        return scanner.nextLine();
    }

    @Override
    public int inputNumberOfCars() {
        return scannerInput();
    }

    @Override
    public int inputTryCount() {
        return scannerInput();
    }

    int scannerInput() {
        return scanner.nextInt();
    }
}
