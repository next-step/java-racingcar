package racingcar.domain;

public class Name {

    private static final int NAME_LIMIT_LENGTH = 5;

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
            throw new IllegalArgumentException();
        }
    }
}
