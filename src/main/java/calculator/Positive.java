package calculator;

public class Positive {
    private final int number;

    public Positive(String text) {
        int number = toInt(text);
        checkNegative(number);

        this.number = number;
    }

    private int toInt(String text) {
        return Integer.parseInt(text);
    }

    private void checkNegative(int number) {
        if (number < 0) {
            throw new RuntimeException("음수 값은 허용되지 않습니다.");
        }
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object number) {
        return this.number == (int) number;
    }

}
