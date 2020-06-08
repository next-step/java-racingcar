package step4;

import java.util.List;
import java.util.Objects;

public class Round {

    private final int round;

    public Round(int round) {
        valid(round);
        this.round = round;
    }

    private void valid(int round) {
        if(round == 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round1 = (Round) o;
        return round == round1.round;
    }

    @Override
    public int hashCode() {
        return Objects.hash(round);
    }

    public int getRound() {
        return round;
    }

    public List<Car> start(Cars cars, Fuel fuel) {
        for(int i = 0; i < round; i++) {
            return cars.move(fuel);
        }
        return null;
    };
}