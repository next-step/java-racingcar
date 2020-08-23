package racingcar.view;

import static racingcar.Constants.*;

public class InputView {
    private static InputChannel inputChannel;
    private static OutputChannel outputChannel;

    public InputView(InputChannel inputChannel, OutputChannel outputChannel) {
        this.inputChannel = inputChannel;
        this.outputChannel = outputChannel;
    }

    public static String getCarNames() {
        outputChannel.printLine(ASK_CAR_NAMES);
        return inputChannel.getStringValue();
    }

    public static int getRacingCounts() {
        outputChannel.printLine(ASK_RACING_COUNT);
        return inputChannel.getIntValue();
    }


}

