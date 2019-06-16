package racingcar.model;

public abstract class CarMover implements Mover<Car> {

    protected abstract boolean isMove();

    @Override
    public boolean move(Car car) {
        if (isMove()) {
            car.move();
            return true;
        }
        return false;
    }
}
