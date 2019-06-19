package racing;

import racing.view.InputView;
import racing.vo.GameMakingInfo;

public class TestInputView extends InputView {
    @Override
    public GameMakingInfo requestGameInfo() {
        return new GameMakingInfo(TestData.DEFAULT_CAR_NAME, TestData.DEFAULT_TIME);
    }
}
