package calculator;

import java.util.Scanner;

public class Input {
    private static final String WHITE_SPACE= " ";
    private String stringValue;

    public Input() {
        System.out.println("문자열 계산식을 입력해주세요 :");
        Scanner scanner = new Scanner(System.in);
        this.stringValue =  scanner.nextLine().replaceAll(" ","");
    }

    public String[] isSplit(String testInput) {
        if (checkBlank(testInput)) {
            throw new IllegalArgumentException();
        }
        return splitter(testInput);
    }

    private String[] splitter(String input) {
        return input.split(WHITE_SPACE);
    }

    private Boolean checkBlank(String blankValue) {
        return (blankValue == null || blankValue.equals(""));
    }
}
