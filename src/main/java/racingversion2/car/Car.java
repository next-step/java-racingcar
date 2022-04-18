package racingversion2.car;


import racingversion2.car.util.MoveDecider;

public class Car {

    private CarName carName;
    private Position position;

    public Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public void move() {
        if(MoveDecider.isMovingForwardCondition()){
            position.increase();
        }
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
