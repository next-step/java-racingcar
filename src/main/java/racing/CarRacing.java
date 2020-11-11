package racing;

import racing.domain.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        raceRound = new RaceRound(getRaceResults());
    }

    private List<RaceResult> getRaceResults() {
        return IntStream.range(0,maxLaps)
                .mapToObj(e -> new RaceResult(carMoves()))
                .collect(Collectors.toList());
    }

    private List<Car> carMoves() {
        return cars.moves(raceRule());
    }

    public RaceRule raceRule() {
        return new RaceMovementRule();
    }

}
