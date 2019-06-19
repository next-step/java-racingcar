package com.jaeyeonling.racingcar.exception;

public class ParticipantsShorterThanMinException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "참여자는 %d 이하가 될 수 없습니다. (입력 값: %d)";

    public static final int MINIMUM_NUMBER_OF_PARTICIPANTS = 0;

    public ParticipantsShorterThanMinException(final int input) {
        super(String.format(ERROR_MESSAGE, MINIMUM_NUMBER_OF_PARTICIPANTS, input));
    }
}