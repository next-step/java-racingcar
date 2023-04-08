package study.carrace.step3.presentation.exception;

public class IllegalIterationCountException extends RuntimeException {
    private static final String MESSAGE = "시도 횟수는 한번 이상이여야 합니다";

    public IllegalIterationCountException(int iterationCount) {
        super(MESSAGE + ": " + iterationCount);
    }
}
