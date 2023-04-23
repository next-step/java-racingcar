package racing.domain;

public class Car {

    private static final Integer RANDOM_MAX = 9;
    private static final Integer MOVE_MIN = 4;

    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(int randomNumber) {
        if (randomNumber < 0 || randomNumber > RANDOM_MAX) {
            throw new RuntimeException("랜덤값 경계를 벗어났습니다.");
        }
        if (randomNumber >= MOVE_MIN) {
            position.move();
        }
    }

    public boolean isLocatedAt(int maxPosition) {
        return this.position.isSameWith(maxPosition);
    }

    public Position position() {
        return position;
    }

    public Name name() {
        return name;
    }
}
