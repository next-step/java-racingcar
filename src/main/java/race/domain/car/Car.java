package race.domain.car;

public class Car {

    private static final int THRESHOLD = 4;
    private static final int NAME_LENGTH_LIMIT = 5;

    private final String name;
    private final Position position;

    public Car(String name) {
        validateName(name);

        this.name = name;
        this.position = new Position(0);
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("자동차 이름은 1~5자까지 가능합니다. : " + name);
        }
    }

    public void accelerate(int randomNumber) {
        if (randomNumber > THRESHOLD) {
            move();
        }
    }

    private void move() {
        this.position.forward();
    }

    public String getName() {
        return this.name;
    }

    public int getCurrentPosition() {
        return this.position.getValue();
    }

    public boolean isInPosition(int comparePosition) {
        return this.position.equals(new Position(comparePosition));
    }
}
