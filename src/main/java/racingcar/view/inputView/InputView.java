package racingcar.view.inputView;

import racingcar.view.outputView.OutputChannel;
import racingcar.view.outputView.SystemOut;

import static racingcar.domain.game.utils.Constants.*;

public class InputView {
    private static InputChannel inputChannel = new SystemIn();
    private static OutputChannel outputChannel = new SystemOut();

    private InputView(){}

    public static String getCarNames() {
        outputChannel.printLine(ASK_CAR_NAMES);
        return inputChannel.getStringValue();
    }

    public static int getRacingCounts() {
        outputChannel.printLine(ASK_RACING_COUNT);
        return inputChannel.getIntValue();
    }


}

