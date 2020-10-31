package step4.exception;

public class MinimumTryCountException extends IllegalArgumentException {
    public MinimumTryCountException() {
        super("횟수를 1이상 입력 해야 합니다.");
    }
}
