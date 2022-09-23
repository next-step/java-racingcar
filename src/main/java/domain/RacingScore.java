package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingScore {

    private Map<Integer, List<String>> racingScores = new HashMap<>();

    private int index;

    private RacingScore() {}

    public static RacingScore init() {

        return new RacingScore();
    }

    public void save(final RacingCars racingCars) {

        this.racingScores.put(index++, calculator(racingCars.score()));
    }

    private List<String> calculator(final List<RacingCar> score) {

        return score.stream()
                .map(racingCar ->
                        convert(racingCar.moveDistance())
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

    public Map<Integer, List<String>> score() {

        return this.racingScores;
    }
}
