package CarRacing.domain;

public class Car {
    private static final int LIMIT_LENGTH_OF_CAR_NAME = 5;

    private final Position position;

    private final String name;

    public Car(String name) {
        this.name = setName(name);
        this.position = new Position();
    }

    public Car(String name, int position) {
        this.name = setName(name);
        this.position = new Position(position);
    }

    public void move(int number) {
        this.position.move(number);
    }

    public int currentPosition() {
        return position.currentPosition();
    }

    public String name() {
        return this.name;
    }

    private String setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }

        if (name.length() > LIMIT_LENGTH_OF_CAR_NAME) {
            throw new IllegalArgumentException("이름은 " + LIMIT_LENGTH_OF_CAR_NAME + "자 이하만 가능합니다. [입력값: " + name + "]");
        }

        return name.trim();
    }
}
