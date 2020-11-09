package racingcar.dto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RaceResultValue {

    private static final String ERROR_MESSAGE_NOT_MATCH_RACE = "시도 횟수와 자동차경주 횟수가 일치하지 않습니다.";
    private static final String ERROR_MESSAGE_NOT_EXIST_MAX_SCORE = "우승스코어가 존재하지 않습니다.";

    private final int step;
    private final Map<String, List<StepByCar>> raceStepValueByCarName;

    private RaceResultValue(int tryCount, Map<String, List<StepByCar>> raceStepValueByCarName) {
        this.step = tryCount;
        this.raceStepValueByCarName = raceStepValueByCarName;
    }

    public static RaceResultValue of(int tryCount, List<StepByCar> stepByCars) {
        Map<String, List<StepByCar>> raceStepValueByCarName = stepByCars.stream()
                .collect(Collectors.groupingBy(StepByCar::getName));

        validate(tryCount, raceStepValueByCarName);

        return new RaceResultValue(tryCount, raceStepValueByCarName);
    }

    private static void validate(int tryCount, Map<String, List<StepByCar>> raceStepValueByCarName) {
        raceStepValueByCarName.values()
                .forEach(v -> {
                    if (tryCount != v.size()) {
                        throw new IllegalArgumentException(ERROR_MESSAGE_NOT_MATCH_RACE);
                    }
                });
    }

    public int getStepCount() {
        return step;
    }

    public int getLastIndex() {
        return step - 1;
    }

    public Map<String, List<StepByCar>> getRaceStepValueByCarName() {
        return raceStepValueByCarName;
    }

    public int getMaxScore() {
        return raceStepValueByCarName.values().stream()
                .mapToInt(raceStepValues -> raceStepValues.get(getLastIndex()).getPosition())
                .max()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_NOT_EXIST_MAX_SCORE));
    }

    public List<String> getWinnerName() {
        return raceStepValueByCarName.entrySet().stream()
                .filter(v -> v.getValue().get(getLastIndex()).getPosition() == getMaxScore())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
