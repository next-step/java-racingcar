package study.racingcar.domain;

public class Car {

    private Position position;

    private CarName carName;
    
    public Car(String name, int position) {
        this.carName = new CarName(name);
        this.position = new Position(position);
    }

    public Car(String name) {
        this(name, 0);
    }

    public void moveCar(CarMovingStrategy carMovingStrategy) {
        if (carMovingStrategy.canMoveCar()) {
            this.position = position.moveForward();
        }
    }

    public int getPosition() {
        return this.position.getValue();
    }

    public String getName() {
        return carName.getValue();
    }

}
