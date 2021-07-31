package racing.domain;

public class Name {

    private static final int MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }

        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_LENGTH + "자 이하로 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }

}
