package racing.domain;

public class Car {

    private static final Integer DEFAULT_POSITION = 0;
    private static final Integer RANDOM_MAX = 9;
    private static final Integer MOVE_MIN = 4;

    private final Name name;
    private int position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = DEFAULT_POSITION;
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public void move(int randomNumber) {
        if (randomNumber < 0 || randomNumber > RANDOM_MAX) {
            throw new RuntimeException("랜덤값 경계를 벗어났습니다.");
        }
        if (randomNumber >= MOVE_MIN) {
            position += 1;
        }
    }

    public boolean isLocatedAt(int maxPosition) {
        return this.position == maxPosition;
    }

    public int position() {
        return position;
    }

    public Name name() {
        return name;
    }
}
