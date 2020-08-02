package racingcar.ui;

import java.util.Scanner;

public class ScannerInput extends RacingDataInput {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    int inputNumberOfCars() {
        return scannerInput();
    }

    @Override
    int inputTryCount() {
        return scannerInput();
    }

    int scannerInput() {
        return scanner.nextInt();
    }
}
