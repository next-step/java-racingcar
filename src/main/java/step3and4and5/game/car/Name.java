package step3and4and5.game.car;

import java.util.Objects;

public class Name {

    private final String value;

    private Name(String value) {
        this.value = value;
    }

    public String print() {
        return value + " : ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public static class Factory {

        private final String name;

        public Factory(String name) {
            this.name = name;
        }

        public Name name() {
            verifyLengthMustNotExceedFive();
            return new Name(name);
        }

        private void verifyLengthMustNotExceedFive() {
            verifyValidName();

            if (name.length() > 5) {
                throw new IllegalStateException("이름은 5글자를 초과할 수 없다.");
            }
        }

        private void verifyValidName() {
            if (name == null || name.isEmpty() || name.isBlank()) {
                throw new IllegalStateException("이름이 null 값이거나 공백일 수 없습니다.");
            }
        }

    }
}
