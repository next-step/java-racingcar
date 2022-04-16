package step_3.service;

import step_3.model.GameCondition;
import step_3.view.InputView;

public class GameConditionService {

    private final static String HOW_MANY_RACING_CARS = "자동차 대수는 몇 대 인가요?";
    private final static String HOW_MANY_TRY = "시도할 회수는 몇 회 인가요?";

    public GameCondition createGameCondition() {
        int totalRacingCarCount = InputView.inputIntValueWithMessage(HOW_MANY_RACING_CARS);
        int totalRounds = InputView.inputIntValueWithMessage(HOW_MANY_TRY);

        return new GameCondition(totalRounds, totalRacingCarCount);
    }
}
