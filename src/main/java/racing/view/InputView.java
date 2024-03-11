package racing.view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);
    private static final String VALID_CHARACTER = "^[a-zA-Z,]*$";
    private static final String DELIMITER = ",";

    public String[] inputStrings(String question) {
        outputQuestion(question);
        String[] inputStrings = getStringsInput();
        return inputStrings;
    }

    private void outputQuestion(String question) {
        System.out.println(question);
    }

    private String[] getStringsInput() {
        String inputString = scanner.nextLine();

        while (!isValidInputString(inputString) || !isValidNameLength(inputString)) {
            System.out.println("공백 없이 쉼표를 기준으로 나누어, 5글자 이하의 자동차의 이름을 입력해주세요.\n(ex: nicky,kim)");
            inputString = scanner.nextLine();
        }

        return separateNames(inputString);
    }

    private boolean isValidInputString(String inputString) {
        return inputString.matches(VALID_CHARACTER);
    }

    private boolean isValidNameLength(String inputString) {
        String[] names = separateNames(inputString);

        return Arrays.stream(names).allMatch(this::isShorterThanSix);
    }

    private String[] separateNames(String inputString) {
        String[] names = inputString.split(DELIMITER);
        return names;
    }

    private boolean isShorterThanSix(String value) {
        return !value.isBlank() && value.length() <= 5;
    }

    public int inputNumber(String question) {
        outputQuestion(question);
        int number = getPositiveNumberInput();
        return number;
    }

    private int getPositiveNumberInput() {
        String inputString = scanner.next();

        while (!isPositiveNumber(inputString)) {
            System.out.println("0을 초과하는 숫자만 입력해 주시길 바랍니다.\n(ex: 5)");
            inputString = scanner.next();
        }

        return Integer.parseInt(inputString);
    }

    private boolean isPositiveNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            return number > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
