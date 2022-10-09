package study;

public class InputNumber {
    private int value;
    private static final String NEGATIVE_ERROR_MESSAGE = "음수가 들어왔습니다";

    public InputNumber(int value){
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


}
