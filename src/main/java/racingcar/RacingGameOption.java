package racingcar;

import java.util.Arrays;
import java.util.List;

public class RacingGameOption {

    public static final String SEPARATOR = ",";

    private List<String> racingCarNames;
    private int numberOfTimes;

    public RacingGameOption(String racingCarNames, int numberOfTimes) {
        this.racingCarNames = Arrays.asList(racingCarNames.split(SEPARATOR));
        this.numberOfTimes = numberOfTimes;
    }

    public List<String> getRacingCarNames() {
        return racingCarNames;
    }

    public int getNumberOfTimes() {
        return numberOfTimes;
    }
}