package racingcar.domain;

public class Util {
    private static final int CAR_LENGTH = 5;

    public boolean invalidedName(String name) {
        if (name.length() > CAR_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없다.");
        }
        return true;
    }
}
