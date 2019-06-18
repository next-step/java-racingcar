package racing;

import racing.view.RacingView;
import racing.vo.GameMakingInfo;

public class TestRacingView extends RacingView {
    @Override
    public void requestGameInfo() {
        controller.makeNewGame(new GameMakingInfo(TestData.DEFAULT_CAR_NAME, TestData.DEFAULT_TIME));
    }
}
