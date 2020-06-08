package step4;

import java.util.List;
import java.util.Objects;

public class Race {
    private final Cars cars;
    private final Round round;

    public Race(Cars cars, Round round) {
        valid(cars, round);
        this.cars = cars;
        this.round = round;
    }

    private void valid(Cars cars, Round round) {
        if(cars == null || round == null) {
            throw new IllegalArgumentException();
        }
    }

    public List<Car> start(Fuel fuel) {
        return round.start(cars, fuel);
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return Objects.equals(cars, race.cars) &&
                Objects.equals(round, race.round);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, round);
    }


}