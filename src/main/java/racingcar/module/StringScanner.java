package racingcar.module;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringScanner {
    public static Scanner scanner = new Scanner(System.in);

    public static List<String> insertCarNameList() {
        InputView.showInsertCarNameListPhrase();
        String[] carNames = scanner.nextLine().split(",");
        return Arrays.asList(carNames);
    }
}
