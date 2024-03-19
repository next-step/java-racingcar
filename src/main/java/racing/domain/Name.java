package racing.domain;

public class Name {
    private static final int MINIMUM_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void validateName(String name) {
        if (name.length() > MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 다섯 글자를 초과할 수 없습니다.");
        }
    }
}
