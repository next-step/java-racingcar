package racingcar.domain;

public class Name {
    private static final int NAME_LENGTH_BOUND = 5;

    private final String name;

    public Name(String name) {
        this.name = name;
        validateName(this.name);
    }

    private void validateName(String name) {
        if (isEmptyName(name)) {
            throw new IllegalArgumentException("이름을 입력해 주세요");
        }
        if (name.length() > NAME_LENGTH_BOUND) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다");
        }
    }

    private boolean isEmptyName(String name) {
        return name == null || name.isEmpty();
    }

    public String value() {
        return name;
    }

}
