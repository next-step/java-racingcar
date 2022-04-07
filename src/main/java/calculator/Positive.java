package calculator;

public class Positive {
    private static final int MIN_NUMBER = 0;
    private static final String NEGATIVE_NUMBER_NOT_ALLOW_MESSAGE = "음수 값은 허용되지 않습니다.";

    private final int number;

    public Positive(String text) {
        this(Integer.parseInt(text));
    }

    public Positive(int number) {
        checkNegative(number);

        this.number = number;
    }

    private void checkNegative(int number) {
        if (number < MIN_NUMBER) {
            throw new RuntimeException(NEGATIVE_NUMBER_NOT_ALLOW_MESSAGE);
        }
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object object) {
        Positive positive = (Positive) object;
       
        return this.number == positive.getNumber();
    }

}
