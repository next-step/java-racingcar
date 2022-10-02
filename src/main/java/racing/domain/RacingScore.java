package racing.domain;

import racing.dto.RacingCarDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingScore {

    private final Map<Integer, List<RacingCarDto>> racingScores = new HashMap<>();
    private int sequence = 0;

    private RacingScore() {}

    public static RacingScore init() {

        return new RacingScore();
    }

    public Map<Integer, List<RacingCarDto>> score() {

        return racingScores;
    }

    public void save(final RacingCars racingCars) {

        racingScores.put(sequence++, getRacingCars(racingCars));
    }

    private List<RacingCarDto> getRacingCars(final RacingCars racingCars) {

        return racingCars.score()
                .stream()
                .map(RacingCarDto::from)
                .collect(Collectors.toList());
    }

    public List<RacingCarDto> findByIndex(final int index) {

        return racingScores.get(index);
    }
}
