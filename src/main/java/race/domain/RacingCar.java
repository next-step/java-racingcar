package race.domain;

import race.model.CarName;
import race.model.Position;

public class RacingCar {
    private Position position;
    private CarName name;

    public RacingCar(CarName name, Position position) {
        this.name = name;
        this.position = position;
    }

    public RacingCar(String name, Position position) {
        this(new CarName(name), position);
    }

    public RacingCar(String name, int position) {
        this(name, new Position(position));
    }

    public RacingCar(String name) {
        this(name, 0);
    }

    public RacingCar(CarName name, int position) {
        this(name, new Position(position));
    }

    public RacingCar(CarName name) {
        this(name, 0);
    }


    public CarName getName() {
        return this.name;
    }

    public Position getPosition() {
        return this.position;
    }

    public void moveForward(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position.move();
        }
    }

    public boolean hasSamePosition(int position) {
        return this.position.hasSamePosition(position);
    }

    public int findMaxValue(int maxValue) {
        return this.position.findMaxValue(maxValue);
    }

    public void drawForwardDistance(String forwardString) {
        this.position.drawForwardDistance(forwardString);
    }
}