package racingcar.domain.dto;

import java.util.List;

public class InputDto {

    private List<String> splitUserInput;
    private int racingTime;

    public List<String> getSplitUserInput() {
        return splitUserInput;
    }

    public int getRacingTime() {
        return racingTime;
    }

    public void setSplitUserInput(List<String> splitUserInput) {
        this.splitUserInput = splitUserInput;
    }

    public void setRacingTime(int racingTime) {
        this.racingTime = racingTime;
    }
}
