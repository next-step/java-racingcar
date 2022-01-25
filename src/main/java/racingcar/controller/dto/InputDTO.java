package racingcar.controller.dto;

import java.util.List;

public class InputDTO {
    private List<String> splitUserInput;
    private String carNameInput;
    private int racingTryCounter;

    public InputDTO(List<String> splitUserInput, String carNameInput, int racingTryCounter) {
        this.splitUserInput = splitUserInput;
        this.carNameInput = carNameInput;
        this.racingTryCounter = racingTryCounter;
    }

    public List<String> getSplitUserInput() {
        return splitUserInput;
    }

    public int getRacingTryCounter() {
        return racingTryCounter;
    }
}
