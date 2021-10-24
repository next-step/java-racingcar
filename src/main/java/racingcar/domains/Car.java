package racingcar.domains;

import racingcar.utils.StringUtils;

public class Car {

    private final String name;
    private final int position;

    public Car(String name) {
        this(name, 0);
    }


    public Car(String name, int position) {
        validateCarName(name);
        this.name = name;
        this.position = position;
    }


    private void validateCarName(String name) {
        boolean result = StringUtils.isLengthWithinLimits(1, 5, name);
        if (!result) {
//            throw new Exception("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

}
