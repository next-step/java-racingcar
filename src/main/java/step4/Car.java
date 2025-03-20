package step4;

import java.util.Objects;

public class Car {
    private final CarName carName;
    private int position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = 0;
    }

    public Car() {
        this.carName = new CarName("name");
        this.position = 0;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.canMove()) {
            position++;
        }
    }

    int getPosition() {
        return this.position;
    }


    public CarStatus toCarStatus() {
        return new CarStatus(this.carName.getCarName(), this.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
