package step4;

import java.util.List;
import java.util.Objects;

public class Race {
    private final Cars cars;
    private final Round round;

    public Race(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public List<Car> start(Fuel fuel) {
        for(int i = 0; i < round.getRound(); i++) {
            return cars.move(fuel);
        }
        return null;
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