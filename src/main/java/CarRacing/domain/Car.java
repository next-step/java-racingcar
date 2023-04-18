package CarRacing.domain;

public class Car {
    private static final int INITIAL_POSITION=1;

    private int position;
    private final String name;

    public Car(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다. [입력값: " + name + "]");
        }

        this.name = name.trim();
        this.position = INITIAL_POSITION;
    }

    public void move(int number) {
        this.position += number;
    }

    public int currentPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
