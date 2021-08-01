package step2;

public class Calculator {

    public static int calculate(String in) {

        _checkInput(in);

        return _calculate(in.split(" "));
    }

    private static void _checkInput(String in) {
        if(in == null || in.isEmpty()) {
            throw new IllegalArgumentException("input 값이 없습니다.");
        }
    }

    private static int _calculate(String[] arr) {

        int current = Integer.parseInt(arr[0]); // 왼쪽 항

        for(int i = 1; i < arr.length; i ++) {
            switch (arr[i]) {
                case "+" :
                    current = _add(current, Integer.parseInt(arr[i + 1]));
                    break;
                case "-" :
                    current = _subtract(current, Integer.parseInt(arr[i + 1]));
                    break;
                case "*" :
                    current = _multiply(current, Integer.parseInt(arr[i + 1]));
                    break;
                case "/" :
                    current = _divide(current, Integer.parseInt(arr[i + 1]));
                    break;
                default :
                    throw new IllegalArgumentException("+, -, *, / 외에 다른 문자가 입력 되었습니다.");
            }

            i ++;
        }

        return current;
    }

    private static int _add(int a, int b) {
        return a + b;
    }

    private static int _subtract(int a, int b) {
        return a - b;
    }

    private static int _multiply(int a, int b) {
        return a * b;
    }

    private static int _divide(int a, int b) {
        return a / b;
    }
}
