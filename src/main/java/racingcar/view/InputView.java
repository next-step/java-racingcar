package racingcar.view;

import static racingcar.utils.Constants.*;

public class InputView {
    private static InputChannel inputChannel = InputChannel.createSystemIn();
    private static OutputChannel outputChannel = OutputChannel.createSystemOut();

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

