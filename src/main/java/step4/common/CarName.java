package step4.common;

import static step4.common.Constant.CAR_NAME_LENGTH_LIMIT;

public class CarName {

    private final String name;

    public CarName(String name) {
        isValid(name);
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    private void isValid(String name) {
        if (name.length() > CAR_NAME_LENGTH_LIMIT) throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}
