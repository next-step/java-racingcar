package study;

import java.util.Random;

public class Number {
    private int value;
    private static final String NEGATIVE_ERROR_MESSAGE = "음수가 들어왔습니다";

    public Number(int value){
        negativeChk(value);
        this.value = value;
    }

    private void negativeChk(int value){
        if(value < 0){
            throw new IllegalArgumentException(NEGATIVE_ERROR_MESSAGE);
        }
    }

    public int getValue() {
        return this.value;
    }

    public static int getRandom() {
        Random random = new Random();
        return random.nextInt(10);
    }

}
