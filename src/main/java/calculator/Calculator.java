package calculator;

public class Calculator {
    static int add(int a,int b) { return a+b; }

    static int sub(int a,int b) { return a-b; }

    static int mul(int a,int b) { return a * b; }

    static int div(int a,int b) {
        if (b == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    }
}
