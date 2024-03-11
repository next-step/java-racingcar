package racing;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요";
    private static final int CAR_NAME_LENGTH_STANDARD = 5;
    private static final String CAR_NAME_LENGTH_OVER = "자동차 이름은 5자를 초과할 수 없습니다. 다시 입력해주세요.";

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int inputtedNumber(String message) {
        System.out.println(message);

        try {
            return scanNextInt();
        } catch (InputMismatchException e) {
            return inputtedNumber(INPUT_NUMBER_MESSAGE);
        }

    }

    public String[] inputtedCarNameList(String message) {
        System.out.println(message);
        String inputtedCarNames = scanNextLine();

        String[] carNameList = inputtedCarNames.split(",");

        if (isCarNameLengthOverStandard(carNameList)) {
            return inputtedCarNameList(CAR_NAME_LENGTH_OVER);
        }

        return carNameList;
    }

    private boolean isCarNameLengthOverStandard(String[] carNameList) {
        return Arrays.stream(carNameList)
                .anyMatch(carName -> carName.length() > CAR_NAME_LENGTH_STANDARD);
    }

    private int scanNextInt() {
        return Integer.parseInt(scanner.nextLine());
    }
    private String scanNextLine() {
        return scanner.nextLine();
    }

    public void closeScanner() {
        scanner.close();
    }
}
