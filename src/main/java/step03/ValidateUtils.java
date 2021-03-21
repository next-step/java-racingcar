package step03;

public class ValidateUtils {

    public static void inputIsZero(int input1, int input2) {
        if (input1 == 0 || input2 == 0) {
            throw new IllegalArgumentException("입력값은 0 이상이어야 합니다.");
        }
    }

    public static void inputIsZero(int input) {
        if (input == 0) {
            throw new IllegalArgumentException("입력값은 0 이상이어야 합니다.");
        }
    }

    public static void inputStringSplitTextSize(String input) {
        String[] splitStrings = input.split(",");
        for (String string : splitStrings) {
            inputStringIsNullOrMoreThanFiveLetters(string);
        }
    }

    public static void inputStringIsNullOrMoreThanFiveLetters(String input) {
        if (input.length() >= 5 || input.isEmpty()) {
            throw new IllegalArgumentException("차 이름은 0글자 이상 5글자 이하로 입력해주세요.");
        }
    }
}
