package calculator;
import java.util.ArrayDeque;
public class Validator {
    public static void checkEmptyInput(String input) throws IllegalArgumentException {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("공백이거나 비었습니다. 다시 입력해 주세요.");
        }
    }
}