package CarRacing;

import java.util.Objects;

public class Car {

    private CarMove carMove;

    public Car() {
        this.carMove = new CarMove();
    }

    public void carMove(int carMove) {
        this.carMove.increaseCarDistance(carMove);
    }

    public StringBuffer getCarMovingDistance() {
        return this.carMove.getCarMovingDistance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carMove, car.carMove);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carMove);
    }
}
