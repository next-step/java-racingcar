package racingcar.domain;

public class Name {
    private final String name;

    public Name(String name) {
        if (name==null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름을 입력하세요.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
