package step3.domain;

public class Name {
    private static final int ALLOW_LENGTH = 5;

    private final String name;

    public Name(String name) {
        if (name.length() > ALLOW_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + ALLOW_LENGTH + "자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
