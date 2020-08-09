package racingcar;

/**
 * @author daheekim
 * @version : 0.0.0
 */
public class RacingVehicle {

    private CarMover carMover;
    RaceRecord raceRecord;

    public RacingVehicle() {
    }

    public RaceRecord getRaceRecord() {
        return raceRecord;
    }

    public void setCarMover(CarMover carMover) {
        this.carMover = carMover;
    }

    public boolean movable() {
        return carMover.movable();
    }

}
