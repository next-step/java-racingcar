package carracing.domain.race;

import carracing.domain.car.Car;
import carracing.domain.car.RaceCars;
import carracing.domain.race.move.MoveStrategy;

import java.util.List;

public class Race {
    private final RaceCars raceCars;

    public Race(RaceCars raceCars) {
        this.raceCars = raceCars;
    }

    public void run(MoveStrategy moveStrategy) {
        raceCars.move(moveStrategy);
    }

    public List<Car> winners() {
        return raceCars.getFastestCars();
    }

    public RaceCars carHistory() {
        return this.raceCars;
    }
}
