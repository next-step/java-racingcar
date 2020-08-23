package racingcar.view;

import stringcalculator.Constants;

import static racingcar.Constants.*;

public class InputView {
    private static InputChannel inputChannel;
    private static OutputChannel outputChannel;

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

