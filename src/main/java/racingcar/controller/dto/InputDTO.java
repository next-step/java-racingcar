package racingcar.controller.dto;

import java.util.List;

public class InputDTO {
    private List<String> splitUserInput;
    private String carNameInput;
    private int racingTryCounter;

    public List<String> getSplitUserInput() {
        return splitUserInput;
    }

    public void setSplitUserInput(List<String> splitUserInput) {
        this.splitUserInput = splitUserInput;
    }

    public String getCarNameInput() {
        return carNameInput;
    }

    public void setCarNameInput(String carNameInput) {
        this.carNameInput = carNameInput;
    }

    public int getRacingTryCounter() {
        return racingTryCounter;
    }

    public void setRacingTryCounter(int racingTryCounter) {
        this.racingTryCounter = racingTryCounter;
    }
}
