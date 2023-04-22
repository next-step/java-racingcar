package race.domain;

public class Name {

    private final String name;

    private static final int MIN_NAME_LENGTH = 5;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }

        if (isOverThanFive(name)) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }

    private boolean isOverThanFive(String name) {
        return name.length() > MIN_NAME_LENGTH;
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    public String get() {
        return this.name;
    }
}
