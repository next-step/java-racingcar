package study;

public class RandomNumber {

    private static final String NEGATIVE_ERROR_MESSAGE = "음수가 들어왔습니다";
    private static final String RANDOM_ABLE_COUNT_ERROR_MESSAGE = "랜덤값은 10보다 클수없습니다";
    private int value;

    public RandomNumber(int value){
        negativeChk(value);
        randomeAbleCountChk(value);
        this.value = value;
    }

    private void negativeChk(int value){
        if(value < 0){
            throw new IllegalArgumentException(NEGATIVE_ERROR_MESSAGE);
        }
    }

    private void randomeAbleCountChk(int value){
        if(value > 10){
            throw new IllegalArgumentException(RANDOM_ABLE_COUNT_ERROR_MESSAGE);
        }
    }

    public int getValue() {
        return this.value;
    }
}
