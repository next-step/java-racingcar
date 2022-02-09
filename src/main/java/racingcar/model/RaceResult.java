package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RaceResult {

    private final List<Car> raceResultByRound;

    public RaceResult(List<Car> raceResult) {
        this.raceResultByRound = new ArrayList<>();
        for (Car car : raceResult) {
            raceResultByRound.add(new Car(car.getCarName(), car.getPosition()));
        }
    }

    public List<Car> getRaceResultByRound() {
        return raceResultByRound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RaceResult that = (RaceResult) o;
        return Objects.equals(raceResultByRound, that.raceResultByRound);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceResultByRound);
    }
}
