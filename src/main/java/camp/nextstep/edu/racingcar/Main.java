package camp.nextstep.edu.racingcar;

import camp.nextstep.edu.racingcar.view.RacingGameConsole;
import camp.nextstep.edu.racingcar.view.RacingInputView;
import camp.nextstep.edu.racingcar.view.RacingInputViewImpl;
import camp.nextstep.edu.racingcar.view.RacingOutputView;
import camp.nextstep.edu.racingcar.view.RacingOutputViewImpl;

public class Main {

    public static void main(String[] args) {
        RacingInputView racingInputView = new RacingInputViewImpl();
        RacingOutputView racingOutputView = new RacingOutputViewImpl();

        RacingGameConsole console = new RacingGameConsole(racingInputView, racingOutputView);
        console.start();
    }
}
