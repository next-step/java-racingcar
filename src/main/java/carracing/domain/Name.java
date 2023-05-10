package carracing.domain;

public class Name {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다. 입력받은 이름: " + name);
        }
        this.name = name;
    }

    public String get() {
        return name;
    }
}
