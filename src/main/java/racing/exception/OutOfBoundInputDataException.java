package racing.exception;

public class OutOfBoundInputDataException extends IllegalArgumentException {
    public OutOfBoundInputDataException(int inputMinValue) {
        super("입력 범위를 벗어났습니다. 입력 범위의 최소 값은 [" + inputMinValue + "] 입니다.");
    }
    public OutOfBoundInputDataException(int inputMinValue, int inputMaxValue) {
        super("입력 범위를 벗어났습니다. 유효한 입력 범위는 [" + inputMinValue + " ~ " + inputMaxValue + "] 입니다.");
    }
}
