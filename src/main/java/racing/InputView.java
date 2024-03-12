package racing;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner;

    private static final String CAR_NAME_DELIMITER = ",";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요";
    private static final String CAR_NAME_LENGTH_OVER = "자동차 이름은 " + Name.MAX_CAR_NAME_LENGTH + "자를 초과할 수 없습니다. 다시 입력해주세요.";

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

    public List<Name> inputtedCarNameList(String message) {
        System.out.println(message);
        String inputtedCarNames = scanNextLine();

        List<String> strCarNames = StringUtil.splitStringToList(inputtedCarNames, CAR_NAME_DELIMITER);

        try {
            return strNamesToNames(strCarNames);
        } catch (IllegalArgumentException e) {
            return inputtedCarNameList(CAR_NAME_LENGTH_OVER);
        }
    }

    private List<Name> strNamesToNames(List<String> strCarNames) {
        return strCarNames.stream()
                .map(Name::new)
                .collect(Collectors.toList());
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
