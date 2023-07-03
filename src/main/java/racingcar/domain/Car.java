package racingcar.domain;

public class Car {

    private final String name;

    public Car(String name) {
        preAssert(name);
        this.name = name;
    }

    private void preAssert(String name) {
        if (name.length() == 0 || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1~5자 사이로 입력해야됩니다. 입력한 값: \"" + name + "\"");
        }
    }

}
