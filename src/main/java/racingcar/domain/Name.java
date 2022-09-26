package racingcar.domain;

public class Name {
    private static final int NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        if (name.length() > NAME_LENGTH) {
            throw new RuntimeException("이름은 " + NAME_LENGTH + "를 초과할 수 없습니다.");
        }
    }
}
