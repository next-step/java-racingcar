package calculator;

public class PositiveNumber {

    public static final String NOT_POSITIVE = "양수가 아닙니다.";
    private int number;

    public PositiveNumber(int number) {
        if(number < 0){
            throw new RuntimeException(NOT_POSITIVE);
        }
        this.number = number;
    }

    public PositiveNumber(String text) {
        this(Integer.parseInt(text));
    }

    public int getValue() {
        return number;
    }

    public PositiveNumber plus(PositiveNumber positiveNumber){
        this.number += positiveNumber.number;
        return this;
    }

}
