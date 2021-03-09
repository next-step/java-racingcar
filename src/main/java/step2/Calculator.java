package step2;

public class Calculator {
    public static int calculator(String data) {
        String[] arr = data.split(" ");
        int result = Integer.parseInt(arr[0]);
        if (hasNotNullOrNotEmpty(arr)) {
            result = getResult(arr);
        }
        return result;
    }

    public static int getResult(String[] arr) {
        int result = Integer.parseInt(arr[0]);
        for (int i = 1; i < arr.length; i = i + 2) {
            result = chooseOperator(arr[i], result, arr[i + 1]);
        }
        return result;
    }

    // result - 앞서 진행된연산 결과
    // num2 - 현재 연산해야할 수
    public static int chooseOperator(String operator, int result, String num2) {
        if (operator.equals("+")) {
            result = add(result, num2);
        }
        if (operator.equals("-")) {
            result = minus(result, num2);
        }
        if (operator.equals("*")) {
            result = multiple(result, num2);
        }
        if (operator.equals("/")) {
            result = divide(result, num2);
        }
        return result;
    }

    public static boolean hasNotNullOrNotEmpty(String[] arr) {
        for (String s : arr) {
            throwIllegalArgumentException(s);
        }
        return true;
    }

    public static void throwIllegalArgumentException(String s) {
        if (s == null || s.equals(" ")) {
            throw new IllegalArgumentException("Null 값 또는 빈 값을 갖고있습니다.");
        }
    }

    public static int add(int num1, String num2) {
        return num1 + Integer.parseInt(num2);
    }

    public static int minus(int num1, String num2) {
        return num1 - Integer.parseInt(num2);
    }

    public static int multiple(int num1, String num2) {
        return num1 * Integer.parseInt(num2);
    }

    public static int divide(int num1, String num2) {
        return num1 / Integer.parseInt(num2);
    }

}
