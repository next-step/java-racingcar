package racingcar.config;

import java.text.MessageFormat;
import java.util.Arrays;

public enum RacingCarException {

    ARGUMENT_TEXT_BLANK("빈문자열, 공백, 개행은 구분자를 이용해 자를 수 없습니다."),
    INTEGER_FORMAT_INVALID("정수 형태의 숫자만 입력해주세요. [userInput : {0}]"),
    CAR_NAME_NOT_MATCHES_PATTERN("자동차의 이름은 한 글자 이상의 영어 소문자와 숫자만 가능합니다. [name : {0}]"),
    CAR_NAME_LONGER_THAN_MAXIMUM_LENGTH("자동차의 이름은 5글자를 초과할 수 없습니다. [name : {0}]"),
    CAR_NAME_DUPLICATED("자동차 이름은 중복될 수 없습니다. [carNames: {0}]"),
    PLAYING_COUNT_OUT_OF_RANGE("레이싱 시도 횟수는 자연수만 가능합니다. [playingCount : {0}]"),
    MOVEMENT_CONDITION_OUT_OF_RANGE("자동차의 전진/정지 조건은 0이상 9이하의 자연수만 가능합니다. [condition : {0}]"),
    UNEXPECTED_EXCEPTION("알 수 없는 오류가 발생했습니다.");

    private final String message;

    RacingCarException(final String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }

    public <T> String message(T value) {
        return MessageFormat.format(this.message, value);
    }

    public <T> String message(T[] values) {
        return message(Arrays.toString(values));
    }
}
