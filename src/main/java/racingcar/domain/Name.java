package racingcar.domain;

public class Name {

    private final String name;

    private Name(String name) {
        validate(name);
        this.name = name;
    }

    public static Name from(String name) {
        return new Name(name);
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new RuntimeException("이름은 다섯자 이하만 가능합니다.");
        }
    }
}
