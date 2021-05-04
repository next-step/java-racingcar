package step5;

public class Util {
    /**
     * 입력값 나누기 & validation
     */
    public static String[] getSplitInputs(String input) {
        input = validateInput(input);
        String[] names = input.split(",");
        return names;
    }

    /**
     * 입력값이 비었는지 확인
     */
    public static String validateInput(String input) {
        input = removeBlank(input);
        if (input.replace(",", "").length() == 0) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
        return input;
    }

    private static String removeBlank(String input) {
        return input.replace(" ", "");
    }
}
