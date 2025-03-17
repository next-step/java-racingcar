package racingcar;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;

    private int position;
    private final String name;

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public static Car of(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
        return new Car(0, name);
    }


    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return name;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position++;
        }
    }
}
