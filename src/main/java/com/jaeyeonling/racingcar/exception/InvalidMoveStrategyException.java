package com.jaeyeonling.racingcar.exception;

public class InvalidMoveStrategyException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "MoveStrategy 는 null 일 수 없습니다.";

    public InvalidMoveStrategyException() {
        super(ERROR_MESSAGE);
    }

}
