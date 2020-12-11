package carrace.domain;


public class Car {
    private static final int DEFAULT_POSITION = 1;
    private static final int MIN_FORWARD_NUMBER = 4;

    private final Position position;
    private final CarName carName;

    public Car() {
        this(DEFAULT_POSITION);
    }

    public Car(int position) {
        this(position, "");
    }

    public Car(CarName name) {
        this(DEFAULT_POSITION, name);
    }

    public Car(int position, String name) {
        this(position, new CarName(name));
    }

    public Car(int position, CarName name) {
        this.position = new Position(position);
        this.carName = name;
    }

    private boolean canMoveForward(int randomNumber) {
        return randomNumber >= MIN_FORWARD_NUMBER;
    }

    public void tryToMoveForward(RacingRule racingRule) {
        int generateNumber = racingRule.generateNumber();
        if (canMoveForward(generateNumber)) {
            moveForward();
        }
    }

    private void moveForward() {
        position.forward();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return carName.getName();
    }

    public String getRacingResult() {
        return carName.getResult() + position.getResult();
    }

}
