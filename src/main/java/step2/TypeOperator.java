package step2;

public class TypeOperator {

    static void isPositive(int answer) {
        if (answer >= 0) return;
        throw new RuntimeException();
    }

    static int getParseInt(String token) {
        return Integer.parseInt(token);
    }
}
