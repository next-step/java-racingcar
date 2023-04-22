package race.domain.car;

import race.datamapper.RaceDataMapper;
import race.dto.CarInfoDto;

import java.util.Objects;

public class Car {
    private final Location location;
    private final Name name;

    public Car(Name name) {
        this.location = new Location(0);
        this.name = name;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMove()) {
            this.location.moveOnePoint();
        }
    }

    public CarInfoDto currentCarInfo() {
        return RaceDataMapper.toCarInfoDto(this.location.location(), this.name.name());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(location, car.location) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, name);
    }
}