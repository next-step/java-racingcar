package racing;

import racing.view.RacingView;
import racing.vo.GameMakingInfo;

public class TestRacingView extends RacingView {
    @Override
    public GameMakingInfo requestGameInfo() {
        return new GameMakingInfo(TestData.DEFAULT_CAR_NAME, TestData.DEFAULT_TIME);
    }
}
