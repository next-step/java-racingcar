package step5.domain;

public class CarName {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        assertNameLengthUnderFive(name);
        this.name = name;
    }

    public String value() {
        return this.name;
    }

    private void assertNameLengthUnderFive(String name) {
        if (CAR_NAME_MAX_LENGTH < name.length()) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}
