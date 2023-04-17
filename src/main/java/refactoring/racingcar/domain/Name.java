package refactoring.racingcar.domain;

public class Name {
    private String name;

    public Name(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public String getValue() {
        return name;
    }
}
