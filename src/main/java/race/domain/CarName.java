package race.domain;

public class CarName {

    private final static int MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        this.name = name;
        validateEmpty();
        validateLength();
    }

    private void validateEmpty() {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름의 문자열은 필수값입니다.");
        }
    }

    private void validateLength() {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
