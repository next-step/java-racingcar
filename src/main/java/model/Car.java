package model;

public class Car {
    private static final int MAX_LENGTH = 5;
    private int position;
    private final  String name;

    public Car(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Car name cannot be null or empty");
        }
        if(name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_LENGTH + "자 이하로 입력해주세요.");
        }
        this.position = 0;
        this.name = name;
    }

    public int move(MoveStrategy condition) {
        if (condition.isMovable()) {
            this.position++;
        }
        return this.position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
