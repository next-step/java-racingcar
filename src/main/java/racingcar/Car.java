package racingcar;

public class Car {

    private static final int MOVED_NUMBER = 4;

    private final RandomNumberGenerator randomNumberGenerator;
    private final CarName carName;
    private final Position position;

    public Car(final String name, final RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.carName = new CarName(name);
        this.position = new Position();
    }

    public void racing() {
        if (isMove()) {
            position.numberIncrease();
        }
    }

    private boolean isMove() {
        return randomNumberGenerator.generate() >= MOVED_NUMBER;
    }

    public boolean isWinner(Car car) {
        return car.samePosition(this.position);
    }

    private boolean samePosition(Position position) {
        return position.equals(this.position);
    }

    public int comparePosition(Car car) {
        return this.position.compareTo(car.getPosition());
    }

    private Position getPosition() {
        return this.position;
    }

    public int positionValue() {
        return this.position.getNumber();
    }

    public String nameValue() {
        return this.carName.getName();
    }
}
