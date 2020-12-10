package racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String COMMA = ",";


    public static List<String> scanInputSplitByComma() {
        return inputSplit(SCANNER.nextLine());
    }

    public static int scanInt() {
        return SCANNER.nextInt();
    }

    public static List<String> inputSplit(String inputString) {
        return Arrays.asList(inputString.split(COMMA));
    }
}
