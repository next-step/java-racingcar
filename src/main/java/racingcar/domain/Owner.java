package racingcar.domain;


public class Owner {

    private final String name;
    private static final int MAX_CAR_NAME_SIZE = 5;

    public Owner(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 존재해야 합니다.");
        }

        if (name.length() > MAX_CAR_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
