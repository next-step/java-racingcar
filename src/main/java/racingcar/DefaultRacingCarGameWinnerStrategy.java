package racingcar;

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

    private List<RacingCar> sort(List<RacingCar> racingCars) {
        racingCars = new ArrayList<>(racingCars);
        Collections.sort(racingCars);
        return racingCars;
    }

    @Override
    public List<RacingCar> getWinners(List<RacingCar> racingCars) {
        if (racingCars == null || racingCars.isEmpty()) {
            return Collections.emptyList();
        }

        racingCars = sort(racingCars);
        RacingCar winner = racingCars.get(0);

        return racingCars
            .stream()
            .filter(car -> winner.compareTo(car) == 0)
            .collect(Collectors.toList());
    }
}
