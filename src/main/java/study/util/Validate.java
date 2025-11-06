package study.util;

public class Validate {

    public static void validatePositive(int number) {
        if (checkNegativeNumber(number)) {
            throw new RuntimeException("0보다 작은 수는 입력할 수 없습니다.");
        }
    }

    private static boolean checkNegativeNumber(int number) {
        return number < 0;
    }

    public static void validateNullOrEmpty(String input) {
        if(input == null || input.isEmpty()){
            throw new RuntimeException("입력값은 필수입니다.");
        }
    }

}
