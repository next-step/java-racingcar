package step2;

public class StringCalculator {
    public int addOperation(String text) {
        int result = textCheck(text);
        return result;
    }

    public int textCheck(String text) {
        if (text == null) {
            return 0;
        }
        if (text.isEmpty()) {
            return 0;
        }
        throw new RuntimeException();
    }
}
