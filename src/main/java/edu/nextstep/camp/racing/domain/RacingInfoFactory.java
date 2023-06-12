package edu.nextstep.camp.racing.domain;

import edu.nextstep.camp.racing.view.InputView;
import edu.nextstep.camp.racing.view.OutputView;

public class RacingInfoFactory {
    private static final String CAR_NAME_INPUT_GUIDE_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MOVING_COUNT_INPUT_GUIDE_MSG = "시도할 회수는 몇회인가요?";
    public RacingInfo createRacingInfo() {
        try {
            return RacingInfo.of( inputCarNames(), inputMovingCount());
        } catch (RuntimeException e){
            OutputView.print(e.getMessage());
            return createRacingInfo();
        } finally {
            InputView.close();
        }
    }

    private String inputCarNames(){
        OutputView.print(CAR_NAME_INPUT_GUIDE_MSG);
        return InputView.input();
    }

    private String inputMovingCount(){
        OutputView.print(MOVING_COUNT_INPUT_GUIDE_MSG);
        return InputView.input();
    }
}
