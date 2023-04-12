package step2;

public class PositiveInt {

    void isPositive(int answer) {
        if (answer >= 0) return;
        throw new RuntimeException();
    }

    int getParseInt(String token) {
        return Integer.parseInt(token);
    }
}
