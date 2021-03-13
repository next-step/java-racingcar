package racingcar;

import racingcar.views.InputView;

import java.util.Map;

public class RaceMain {

    public void race() {
        Map<String, Integer> racingCarInfos = InputView.getInput();
        int totalCarNum = racingCarInfos.get(InputView.KEY_TOTAL_CAR_NUM);
        int totalMoveCnt = racingCarInfos.get(InputView.KEY_TOTAL_MOVE_CNT);



    }
}
