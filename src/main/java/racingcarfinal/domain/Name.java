package racingcarfinal.domain;

public class Name {

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() == 0 || name.length() > 5) {
            throw new IllegalArgumentException("이름은 없거나 5자를 초과할 수 없습니다.");
        }
    }

    public String getValue() {
        return this.name;
    }

}
