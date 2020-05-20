package CarRacing;

public class Car {

    private String number;
    private Position position;
    private final int  MOVE_CHECK_VALUE = 4;

    public Car(String number, Position position) {
        this.number = number;
        this.position = position;
    }

    public void move(Direction direction) {
            direction.exec(this.position);
    }

    public void progress(RandomValue randomValue) {
        if (this.moveCheck(randomValue)) {
            this.move(Direction.FORWARD);
        }
    }

    public int getLocation() {
        return position.getLocation();
    }

    public boolean isLocationAt(int location) {
        return this.getLocation() == location;
    }

    private boolean moveCheck(RandomValue randomValue) {
        return randomValue.getRandomValue() >= MOVE_CHECK_VALUE;
    }
}
