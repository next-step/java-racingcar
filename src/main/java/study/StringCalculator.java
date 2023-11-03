package study;

public class StringCalculator {

    public static int cal(String exp) {
        if (isEmpty(exp)) {
            return 0;
        }

        if (exp.length() == 1) {
            return Integer.parseInt(exp);
        }

        String[] numbers;
        if (checkFirstChar(exp)) {
            char customSplitter = exp.charAt(2);
            numbers = exp.substring(4).split(String.valueOf(customSplitter));
        } else {
            numbers = exp.split("[,:]");
        }
        return getSum(numbers);
    }

    private static boolean isEmpty(String exp) {
        return exp == null || exp.isBlank();
    }

    private static boolean checkFirstChar(String str) {
        if (str.charAt(0) != '/') {
            return false;
        }
        return true;
    }

    private static int getSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum = add(sum, number);
        }
        return sum;
    }

    private static int add(int sum, String number) {
        try {
            int value = Integer.parseInt(number);
            if (value < 0) {  // 음수 검사
                throw new RuntimeException();
            }
            sum += value;
        } catch (NumberFormatException e) {  // 숫자 이외의 값 예외처리
            throw new RuntimeException();
        }
        return sum;
    }

}
