package step2;

public class Calculator {

    // 기능 구현 목록
    // input 값
    public String[] inputValue(String input) {
        return input.split(" ");
    }

    // 1. 사칙연산 기능
    public int add(int a, int b) { return a + b; }
    public int sub(int a, int b) {
        return a - b;
    }
    public int mul(int a, int b) {
        return a * b;
    }
    public int div(int a, int b) {
        return a / b;
    }

    // 2. 사칙연산 기호 판단
    public String mathSymbol(int a, int b, String c) {
        int temp = 0;
        if (c.equals("+")) {
            temp = add(a, b);
        } else if (c.equals("-")) {
            temp = sub(a, b);
        } else if (c.equals("*")) {
            temp = mul(a, b);
        } else if (c.equals("/")) {
            temp = div(a, b);
        }
        return Integer.toString(temp);
    }

    // 3. 사칙연산 실행
    public String calculation(String input) {
        Calculator calculator = new Calculator();
        String[] testValue = calculator.inputValue(input);
        String temp2;

        for (int i = 0; i < testValue.length - 1; i++) {
            if (i % 2 == 1) {
                int aValue = Integer.parseInt(testValue[i - 1]);
                int bValue = Integer.parseInt(testValue[i + 1]);
                String calValue = testValue[i];

                temp2 = calculator.mathSymbol(aValue, bValue, calValue);
                testValue[i + 1] = temp2;
            }
        }
        return testValue[(testValue.length - 1)];
    }
}
