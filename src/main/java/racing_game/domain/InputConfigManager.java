package racing_game.domain;

import racing_game.core.Positive;
import racing_game.view.InputView;

public class InputConfigManager {

    public static SimulationConfig getConfig() throws Exception {
        InputView<Positive> inputView = new InputView<>();
        Positive carCount = inputView.fromInput("자동차 대수는 몇 대 인가요?", Positive.zero());
        Positive tryCount = inputView.fromInput("시도할 회수는 몇 회 인가요?", Positive.zero());
        return SimulationConfig.create(carCount, tryCount);
    }
}
