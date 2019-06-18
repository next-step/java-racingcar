package racing.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {

    private static final String WINNERS_NAME_DELIMITER = ", ";

    private List<RacingScore> racingScores = new ArrayList<>();

    private RacingResult() {}

    public static RacingResult initRacingScore(RacingScore racingScore) {

        RacingResult racingResult = new RacingResult();
        racingResult.racingScores.add(racingScore);
        return racingResult;
    }

    public List<RacingScore> getEntireRacingScore() {

        return racingScores;
    }

    public void addCurrentRacingScore(RacingScore racingScore) {

        racingScores.add(racingScore);
    }

    public String getWinnersName() {

        List<CarNamePosition> lastCarNamePositions = racingScores.get(racingScores.size() - 1).getCarNamePositions();
        int winnersPosition = lastCarNamePositions.stream()
                .map(CarNamePosition::getPosition)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalStateException("우승자 계산도중 에러가 발생했습니다."));

        return lastCarNamePositions.stream()
                .filter(carNamePosition -> carNamePosition.getPosition() == winnersPosition)
                .map(CarNamePosition::getCarName)
                .collect(Collectors.joining(WINNERS_NAME_DELIMITER));
    }
}
