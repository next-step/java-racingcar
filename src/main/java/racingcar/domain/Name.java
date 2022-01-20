package racingcar.domain;

public class Name {

    private static final int NAME_LIMIT_LENGTH = 5;
    private static final String NAME_VALIDATION_MESSAGE = "[ERROR] 이름은 5 글자 이하입니다.";

    private String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty() || name.length() > NAME_LIMIT_LENGTH) {
            throw new IllegalArgumentException(NAME_VALIDATION_MESSAGE);
        }
    }
}
