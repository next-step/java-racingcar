package racing;

import racing.domain.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static racing.domain.CarConfig.*;

public class CarRacing {

    private final Cars cars;
    private final int maxLaps;
    private RaceRound raceRound;

    public CarRacing(String carNames, int maxLaps) {
        this.cars = setCars(carNames);
        this.maxLaps = maxLaps;
    }

    private Cars setCars(String names) {
        return new Cars(Arrays.stream(names.split(CAR_NAME_STRING_SEPARATOR))
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public Cars getRacingCars() {
        return cars;
    }

    public RaceRound getRaceRound() {
        return raceRound;
    }

    public void start() {
        List<RaceResult> results = new LinkedList<>();
        for(int i=0; i<maxLaps; i++ ) {
            results.add(i,new RaceResult(cars.moves(raceRule())));
        }
        raceRound = new RaceRound(results);
    }

    public RaceRule raceRule() {
        return new RaceMovementRule();
    }
}
