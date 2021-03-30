package racingcar.domain;

public class Owner {
    private final String name;

    public Owner(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 존재해야 합니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
