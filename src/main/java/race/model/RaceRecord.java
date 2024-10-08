package race.model;

import race.domain.RacingCar;

public class RaceRecord {
    private CarName carName;
    private Position position;


    public RaceRecord(CarName name, Position position) {
        this.carName = name;
        this.position = position;
    }
    public static RaceRecord from(RacingCar car) {
        return new RaceRecord(car.getName(), car.getPosition());
    }

    public String getName() {
        return this.carName.getName();
    }

    public int getPosition() {
        return this.position.getPosition();
    }
}
