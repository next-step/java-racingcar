package racingcar.v2.domain.car;

import racingcar.v2.utils.StringUtils;

import java.util.Objects;

public class Participant {

    private final String name;

    public Participant(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("참가자 이름은 공백이 될수 없습니다.");
        }

        if (StringUtils.isMoreThanFiveLetters(name)) {
            throw new IllegalArgumentException("참가자 이름은 5글자를 초과할수 없습니다.");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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
//        return "Participant{" +
//                "name='" + name + '\'' +
//                '}';
    }
}
