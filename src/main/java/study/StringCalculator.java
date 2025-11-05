package study;

public class StringCalculator {


    public int isEmptyOrNull(String value) {
        return value == null || value.isEmpty() ? 0:-1;
    }
}
