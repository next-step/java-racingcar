package racingcar.domain;

public class CarName {
    private String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("자동차 이름이 없습니다.");
        }

        if (name.trim().length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String get() {
        return name;
    }
}
