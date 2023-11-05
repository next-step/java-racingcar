package study.racing.view;

import study.racing.domain.CarsNumber;
import study.racing.domain.TryCounts;

import java.util.Scanner;

public class InputView {

    public CarsNumber inputCarsNumber() {

        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        return new CarsNumber(value);
    }

    public TryCounts inputTryCounts() {

        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        scanner.close();

        return new TryCounts(value);
    }
}
