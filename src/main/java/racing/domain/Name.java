package racing.domain;

public class Name {

    static final int CAR_NAME_MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        if(name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
