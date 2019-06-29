package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

public class GameRequest {
    private List<String> carNames;
    private Integer numberOfTimes;

    private GameRequest(List<String> carNames, int numberOfTimes) {
        this.carNames = carNames;
        this.numberOfTimes = numberOfTimes;
    }

    public static GameRequest of(List<String> carNames, int numberOfTimes) {
        return new GameRequest(carNames, numberOfTimes);
    }

    public List<String> getCarNames() {
        return new ArrayList<>(carNames);
    }

    public int getNumberOfTimes() {
        return numberOfTimes;
    }
}
