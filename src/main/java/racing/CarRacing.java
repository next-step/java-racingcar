package racing;

import racing.domain.*;

public class CarRacing {

    private final Cars cars;
    private final RaceResult raceResult = new RaceResult();
    private int maxLaps;

    public CarRacing(int vehicleCount, int maxLaps) {
        this.cars = new Cars();
        this.cars.setCars(vehicleCount);
        this.maxLaps = maxLaps;
    }

    public Cars getRacingCars() {
        return cars;
    }

    public RaceResult getRaceResults() {
        return raceResult;
    }

    public void start() {
        for (int i = 0; i < maxLaps; i++) {
            raceResult.setResult(i,cars.moves(raceRule()));
        }
    }

    public RaceRule raceRule() {
        return new RaceMovementRule();
    }
}
