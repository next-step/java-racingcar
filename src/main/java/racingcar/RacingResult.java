package racingcar;

import java.util.List;

public class RacingResult {


    private int movedDistance;
    private List<Car> cars;

    public RacingResult(List<Car> cars) {
        this.cars = cars;
    }

    public int getMovedDistance() {
        return movedDistance;
    }

    public void setMovedDistance(int movedDistance) {
        this.movedDistance = movedDistance;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
