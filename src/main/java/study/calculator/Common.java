package study.calculator;

public class Common {
    public static void checkValue(String input) {
        if(input == null || input.trim().isEmpty()){
            throw new IllegalArgumentException("input Value is null or blank");
        }
    }
}
