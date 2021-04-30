package racing.domain;

public class Car {
    private CarName carName;
    private Distance distance;

    private Car(CarName carName){
        this.carName = carName;
        this.distance = Distance.zero;
    }

    public static Car of(String name) {
        return new Car(CarName.of(name));
    }

    public void move(MovableStrategy movableStrategy) {
        if(movableStrategy.movable()) {
            this.distance = this.distance.plus(Distance.one);
        }
    }

    public Distance getDistance() {
        return this.distance;
    }
}
