package racingcar.domain.car;

public class Name {
    private final static int MAX_NAME_LEN = 5;

    private final String name;

    public Name(String name) {
        checkNameLen(name);

        this.name = name;
    }

    private void checkNameLen(String name) {
        if (name.length() > MAX_NAME_LEN) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return this.name;
    }

}
