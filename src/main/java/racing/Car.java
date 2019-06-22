package racing;

public class Car {

    private Position position;

    public Car() {
        position = new Position();
    }

    public void move(long l) {
        if (l >= 4)
            position.progress();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
