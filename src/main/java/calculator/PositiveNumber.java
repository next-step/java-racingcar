package calculator;

import exception.NegativeNumberException;

public class PositiveNumber {
    private final int value;
    public PositiveNumber(int value){
        if(value < 0) {
            throw new NegativeNumberException("negative value : " + value);
        }
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public PositiveNumber sum(PositiveNumber number) {
        return new PositiveNumber(value + number.getValue());
    }
}
