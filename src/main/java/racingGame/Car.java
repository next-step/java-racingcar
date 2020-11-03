package racingGame;

public class Car {

    private int position;

    Car() {
        this(0);
    }

    Car(int initialPosition) {
        this.position = initialPosition;
    }

    public int move(int delta) {
        position += delta;
        return this.position;
    }

    public int getPosition() {
        return position;
    }
}
