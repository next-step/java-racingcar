package racingcar.view;

import java.util.Scanner;

import static racingcar.Constants.*;

public class InputView {
    private static InputChannel inputChannel;
    private static OutputChannel outputChannel;

    public InputView(InputChannel inputChannel, OutputChannel outputChannel) {
        this.inputChannel = inputChannel;
        this.outputChannel = outputChannel;
    }

    private static int carCounts;
    private static int racingCounts;

    public static int getCarCounts() {
        outputChannel.printLine(ASK_CAR_COUNT);
        return carCounts = inputChannel.getIntValue();
    }

    public static int getRacingCounts() {
        outputChannel.printLine(ASK_RACING_COUNT);
        return racingCounts = inputChannel.getIntValue();
    }
}

