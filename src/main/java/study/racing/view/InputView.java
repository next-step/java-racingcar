package study.racing.view;

import study.racing.domain.Names;
import study.racing.domain.TryCounts;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    public Names inputCarsNumber() {

        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        return new Names(Arrays.asList(value.split(",")));
    }

    public TryCounts inputTryCounts() {

        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        scanner.close();

        return new TryCounts(value);
    }
}
