package racing;

public class RacingGame {

    private Car car;
    public RacingGame(Car car) {
        this.car = car;
    }

    public Car start(int movableCarValue) {
        car.move(movableCarValue);
        return car;
    }

}