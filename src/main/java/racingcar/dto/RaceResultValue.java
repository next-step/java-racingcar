package racingcar.dto;

import java.util.List;

public class RaceResultValue {

    private static final String ERROR_MESSAGE_NOT_MATCH_RACE = "시도 횟수와 자동차경주 횟수가 일치하지 않습니다.";
    private static final String ERROR_MESSAGE_NOT_EXIST_MAX_SCORE = "우승스코어가 존재하지 않습니다.";

    private final int step;
    private final List<StepResult> stepResultList;

    private RaceResultValue(int tryCount, List<StepResult> stepResultList) {
        this.step = tryCount;
        this.stepResultList = stepResultList;
    }

    public static RaceResultValue of(int tryCount, List<StepResult> stepResultList) {
        validate(tryCount, stepResultList);
        return new RaceResultValue(tryCount, stepResultList);
    }

    private static void validate(int tryCount, List<StepResult> stepResultList) {
        if (tryCount != stepResultList.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_MATCH_RACE);
        }
    }

    public int getStepCount() {
        return step;
    }

    public List<StepResult> getStepResults(){
        return this.stepResultList;
    }

    public int getLastIndex() {
        return step - 1;
    }

    public List<String> getFinalWinnerName() {
        return stepResultList.get(getLastIndex()).getWinnerName();
    }
}
