package race.car;

import race.car.dto.CarInfoDto;
import race.datamapper.RaceDataMapper;

public class Car {
    private final Location location;
    private final Name name;
    private static final int MOVE_CONDITION = 4;

    public Car(Name name) {
        this.location = new Location();
        this.name = name;
    }

    public void move(int condition) {
        if (this.isMove(condition)) {
            this.location.moveOnePoint();
        }
    }

    private boolean isMove(int condition) {
        return condition >= MOVE_CONDITION;
    }

    public CarInfoDto currentCarInfo() {
        return RaceDataMapper.toCarInfoDto(this.location.location(), this.name.name());
    }
}