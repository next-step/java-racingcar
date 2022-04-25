package racing.car;

import java.util.Objects;

public class CarName {
    private static final int MIN_NAME_SIZE = 0;
    private static final int MAX_NAME_SIZE = 5;
    String name;

    public CarName(String name) {
        if (Objects.isNull(name) || name.length() == MIN_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요");
        }
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5자를 넘을 수 없습니다.");
        }

        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
