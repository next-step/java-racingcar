package racing.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingScore {

    private static final Map<Integer, List<RacingCar>> racingScores = new HashMap<>();
    private static int sequence = 0;

    private static final RacingScore instance = new RacingScore();

    private RacingScore() {}

    public static RacingScore getInstance() {
        return instance;
    }

    public Map<Integer, List<RacingCar>> score() {

        return racingScores;
    }

    public void save(final RacingCars racingCars) {

        racingScores.put(sequence++, getRacingCars(racingCars));
    }

    private List<RacingCar> getRacingCars(final RacingCars racingCars) {

        return racingCars.score()
                .stream()
                .map(racingCar -> new RacingCar(racingCar.getName(), racingCar.getPosition()))
                .collect(Collectors.toList());
    }

    public List<RacingCar> findByIndex(final int index) {

        return racingScores.get(index);
    }
}
