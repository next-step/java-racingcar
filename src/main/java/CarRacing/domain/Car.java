package CarRacing.domain;

public class Car {
    private static final int INITIAL_POSITION=1;
    private static final int LIMIT_LENGTH_OF_CAR_NAME=5;

    private int position;
    private final String name;

    public Car(String name) {
        this.name = setName(name);
        this.position = INITIAL_POSITION;
    }

    public Car(String name, int position) {
        this.name = setName(name);
        this.position = position;
    }

    public void move(int number) {
        this.position += number;
    }

    public int currentPosition() {
        return this.position;
    }

    public String name() {
        return this.name;
    }

    private String setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }

        if (name.length() > LIMIT_LENGTH_OF_CAR_NAME) {
            throw new IllegalArgumentException("이름은 "+LIMIT_LENGTH_OF_CAR_NAME+"자 이하만 가능합니다. [입력값: " + name + "]");
        }

        return name.trim();
    }
}
