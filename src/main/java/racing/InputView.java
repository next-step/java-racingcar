package racing;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    private static final String CAR_NAME_DELIMITER = ",";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요";
    public static final String NUMBER_UNDER_ZERO_EXCEPTION_MESSAGE = "0 이상의 정수만 입력할 수 있습니다. 다시 입력해주세요.";

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int inputtedNumber(String message) {
        System.out.println(message);

        try {
            return scanNextInt();
        } catch (NumberFormatException e) {
            return inputtedNumber(INPUT_NUMBER_MESSAGE);
        } catch (IllegalArgumentException e) {
            return inputtedNumber(e.getMessage());
        }

    }

    public List<String> inputtedCarNameList(String message) {
        System.out.println(message);
        String inputtedCarNames = scanNextLine();

        List<String> strCarNames = StringUtil.splitStringToList(inputtedCarNames, CAR_NAME_DELIMITER);

        try {
            return strCarNames;
        } catch (IllegalArgumentException e) {
            return inputtedCarNameList(e.getMessage());
        }
    }

    private int scanNextInt() {
        int nextInt = Integer.parseInt(scanner.nextLine());

        if (nextInt < 1) {
            throw new IllegalArgumentException(NUMBER_UNDER_ZERO_EXCEPTION_MESSAGE);
        }

        return nextInt;
    }

    private String scanNextLine() {
        return scanner.nextLine();
    }

    public void closeScanner() {
        scanner.close();
    }
}
