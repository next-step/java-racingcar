package racingcar.control.input;

import racingcar.view.InputView;
import racingcar.view.View;

public class TrialInputControl extends InputControl {

    @Override
    protected View view() {
        return new InputView("시도할 회수는 몇 회 인가요?");
    }
}
