package race.domain;


public class RacingCar {
    private static final int MOVE_CONDITION_NUMBER = 4;
    private Position position;
    private CarName name;

    public RacingCar(String name, Position position) {
        this.name = new CarName(name);
        this.position = position;
    }

    public RacingCar(String name, int position) {
        this(name, new Position(position));
    }

    public RacingCar(String name) {
        this(name, 0);
    }

    public void printName() {

        this.name.printName();
    }

    public void moveForward(int value) {
        if (isMovable(value)) {
            this.position.move();
        }
    }

    public boolean hasSamePosition(int position) {
        return this.position.hasSamePosition(position);
    }

    private boolean isMovable(int number) {
        return number >= MOVE_CONDITION_NUMBER;
    }

    public int findMaxValue(int maxValue) {
        return this.position.findMaxValue(maxValue);
    }

    public String drawForwardDistance(String forwardString) {
        return this.position.drawForwardDistance(forwardString);
    }

    public void printNameWithComma(boolean b) {
        this.name.printNameWithComma(b);
    }
}