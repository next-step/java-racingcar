package racingcar.domain.car;

import racingcar.utils.StringUtils;

import java.util.Objects;

public class Participant {

    private final String name;

    private static final String PARTICIPANT_NAME_BLANK_MESSAGE = "참가자 이름은 공백이 될수 없습니다.";
    private static final String PARTICIPANT_NAME_OVER_MESSAGE = "참가자 이름은 5글자를 초과할수 없습니다.";

    public Participant(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(PARTICIPANT_NAME_BLANK_MESSAGE);
        }

        if (StringUtils.isMoreThanFiveLetters(name)) {
            throw new IllegalArgumentException(PARTICIPANT_NAME_OVER_MESSAGE);
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
