package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultRacingCarGameWinnerStrategy implements RacingCarGameWinnerStrategy {

    private final static DefaultRacingCarGameWinnerStrategy INSTANCE = new DefaultRacingCarGameWinnerStrategy();

    private DefaultRacingCarGameWinnerStrategy() {}

    public static DefaultRacingCarGameWinnerStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public List<RacingCar> getWinners(List<RacingCar> racingCars) {
        if (racingCars == null || racingCars.isEmpty()) {
            return Collections.emptyList();
        }

        RacingCar firstPlace = getFirstPlace(racingCars);

        return racingCars
            .stream()
            .filter(car -> firstPlace.compareTo(car) == 0)
            .collect(Collectors.toList());
    }

    private RacingCar getFirstPlace(List<RacingCar> racingCars) {
        return sort(racingCars).get(0);
    }

    private List<RacingCar> sort(List<RacingCar> racingCars) {
        racingCars = new ArrayList<>(racingCars);
        Collections.sort(racingCars);
        return racingCars;
    }
}
