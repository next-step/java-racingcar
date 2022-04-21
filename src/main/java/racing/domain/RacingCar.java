package racing.domain;

import racing.util.Behavior;
import racing.util.GameRole;

import java.util.Objects;

public class RacingCar {

    private final Name name;

    public RacingCar(String name) {
        this.name = new Name(name);
    }

    public Name getName() {
        return name;
    }

    public Behavior stopOrForward(int roundResult) {
        return GameRole.checkRoundResult(roundResult);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static class Name {
        private final String name;

        public Name(String name) {
            this.checkName(name);
            this.name = name.trim();
        }

        private void checkName(String name) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("레이킹 카의 이름은 5자를 넘을 수 없습니다.");
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Name name1 = (Name) o;
            return Objects.equals(name, name1.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}
