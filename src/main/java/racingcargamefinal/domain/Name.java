package racingcargamefinal.domain;

public class Name {

    private static final int MIN_NAME_LENGTH = 0;
    private static final int MAX_NAME_LENGTH = 5;

    private final String value;

    public Name(String name) {
        validate(name);
        this.value = name;
    }

    private void validate(String name) {
        if (name.length() <= MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 없거나 5자를 초과할 수 없습니다.");
        }
    }

    public String getValue() {
        return value;
    }

}
