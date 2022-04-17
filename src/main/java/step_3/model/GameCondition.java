package step_3.model;

import step_3.view.InputView;

public class GameCondition {

    private static final String HOW_MANY_RACING_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String HOW_MANY_TRY = "시도할 회수는 몇 회 인가요?";
    private final int totalRacingCarCount;
    private final int totalRounds;

    public GameCondition() {
        this.totalRacingCarCount = InputView.inputIntValueWithMessage(HOW_MANY_RACING_CARS);
        this.totalRounds = InputView.inputIntValueWithMessage(HOW_MANY_TRY);
    }

    public int getTotalRounds() {
        return this.totalRounds;
    }

    public int getTotalRacingCarCount() {
        return this.totalRacingCarCount;
    }
}
