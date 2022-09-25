package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingScore {

    private static final Map<Integer, List<String>> racingScores = new HashMap<>();
    private static int sequence = 0;

    private static final RacingScore instance = new RacingScore();

    private RacingScore() {}

    public static RacingScore getInstance() {
        return instance;
    }

    public Map<Integer, List<String>> score() {

        return racingScores;
    }

    public void save(final RacingCars racingCars) {

        racingScores.put(sequence++, calculator(racingCars.score()));
    }

    private List<String> calculator(final List<RacingCar> score) {

        return score.stream()
                .map(racingCar ->
                        convert(racingCar.getPosition())
                )
                .collect(Collectors.toList());
    }

    private String convert(final int position) {

        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        return result.toString();
    }
}
