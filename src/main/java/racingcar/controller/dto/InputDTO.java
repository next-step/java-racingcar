package racingcar.controller.dto;

import java.util.List;

public class InputDTO {

    private final List<String> splitUserInput;
    private final int racingTryCounter;

    public InputDTO(final List<String> splitUserInput,
        final int racingTryCounter) {
        this.splitUserInput = splitUserInput;
        this.racingTryCounter = racingTryCounter;
    }

    public List<String> getSplitUserInput() {
        return splitUserInput;
    }

    public int getRacingTryCounter() {
        return racingTryCounter;
    }
}
