package study.racingcar.domain;

public class TryNo {

    private static final String INPUT_ZERO_OVER_NUMBER_MESSAGE = "0보다 큰 정수를 입력해주세요.";

    private final int tryNo;

    public TryNo(int tryNo) {
        if (tryNo == 0) {
            throw new IllegalArgumentException(INPUT_ZERO_OVER_NUMBER_MESSAGE);
        }
        this.tryNo = tryNo;
    }

    public int value(){
        return this.tryNo;
    }
}
