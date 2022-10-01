package study;

public class Number {

    private int value;
    private static final String NEGATIVE_ERROR_MESSAGE = "음수가 들어왔습니다";

    public Number(int value){
        negativeChk(value);
        this.value = value;
    }

    private void negativeChk(int value){
        if(value < 0){
            throw new RuntimeException(NEGATIVE_ERROR_MESSAGE);
        }
    }

    public int getValue() {
        return value;
    }
}
