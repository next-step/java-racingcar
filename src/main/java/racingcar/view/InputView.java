package racingcar.view;

import racingcar.Constants;

import static racingcar.Constants.*;

public class InputView {
    private static InputChannel inputChannel;
    private static OutputChannel outputChannel;

    private InputView(){
        throw new IllegalArgumentException(Constants.PROTECTED_UTIL_CLASS);
    }

    public InputView(InputChannel inputChannel, OutputChannel outputChannel) {
        this.inputChannel = inputChannel;
        this.outputChannel = outputChannel;
    }

    public static int getCarCounts() {
        outputChannel.printLine(ASK_CAR_COUNT);
        return inputChannel.getIntValue();
    }

    public static int getRacingCounts() {
        outputChannel.printLine(ASK_RACING_COUNT);
        return inputChannel.getIntValue();
    }
}

