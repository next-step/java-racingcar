package racingcar.domain.car;

public class Name {
    private final static int MAX_NAME_LEN = 5;

    private final String name;

    public Name(String name) {
        checkValidName(name);

        this.name = name;
    }

    private void checkValidName(String name) {
        checkNull(name);
        checkBlank(name);
        checkNameLength(name);
    }

    private void checkNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차 이름은 Null이 될 수 없습니다.");
        }
    }

    private void checkBlank(String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있는 문자열이 올 수 없습니다");
        }
    }

    private void checkNameLength(String name) {
        if (name.length() > MAX_NAME_LEN) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public String value() {
        return this.name;
    }

}
