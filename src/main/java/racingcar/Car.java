package racingcar;

public class Car {

    private final static int MOVE_CRITERIA = 4;
    private final String name;
    private int location;

    public static Car of(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
        return new Car(name,0);
    }

    private Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public int location() {
        return this.location;
    }

    public String name() {
        return this.name;
    }

    public void moveDependingOn(int inputValue) {
        if (inputValue >= MOVE_CRITERIA) {
            location++;
        }
    }
}
