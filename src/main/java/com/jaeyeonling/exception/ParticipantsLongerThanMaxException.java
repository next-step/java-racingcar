package com.jaeyeonling.exception;

public class ParticipantsLongerThanMaxException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "참여자는 %d 이상이 될 수 없습니다. (입력 값: %d)";

    public static final int MAXIMUM_NUMBER_OF_PARTICIPANTS = 10_000;

    public ParticipantsLongerThanMaxException(final int input) {
        super(String.format(ERROR_MESSAGE, MAXIMUM_NUMBER_OF_PARTICIPANTS, input));
    }
}