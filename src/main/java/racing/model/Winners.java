package racing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Winners {
    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public List<CarName> getNames() {
        List<CarName> winnerNames = new ArrayList<>();
        for (Car car : winners) {
            winnerNames.add(car.name());
        }
        return winnerNames;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Winners object = (Winners) o;
        return Objects.equals(winners, object.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(winners);
    }
}
