package study.racinggame.domain;

public class Name {
    private static final int MAX_LENGTH = 5;
    private static final int MIN_LENGTH = 2;
    private String name;

    public Name(String name) {
        if (name.length() > MAX_LENGTH || name.length() < MIN_LENGTH) {
            throw new RuntimeException("자동차의 이름은 2자 미만 또는 5자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
