package racing.exception;

import java.util.UUID;

public class DuplicatedCarException extends RacingException {
    private static final String MESSAGE = "이미 등록된 차량입니다.";

    public DuplicatedCarException(UUID carId) {
        this(MESSAGE + "(carId: " + carId + ")");
    }

    public DuplicatedCarException(String message) {
        super(message);
    }

}
