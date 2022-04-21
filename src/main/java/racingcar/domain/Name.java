package racingcar.domain;

public class Name {
    private String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자를 초과 할 수 없습니다.");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름은 공백이 될 수 없습니다.");
        }
    }

    public String showName() {
        return name;
    }

}
