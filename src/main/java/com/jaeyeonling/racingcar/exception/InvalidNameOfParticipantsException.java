package com.jaeyeonling.racingcar.exception;

public class InvalidNameOfParticipantsException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "nameOfParticipants 값은 빈 값일 수 없습니다.";

    public InvalidNameOfParticipantsException() {
        super(ERROR_MESSAGE);
    }
}
