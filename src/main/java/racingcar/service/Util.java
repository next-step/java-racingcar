package racingcar.service;

public class Util {
    public boolean invalidedName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없다.");
        }
        return true;
    }
}
