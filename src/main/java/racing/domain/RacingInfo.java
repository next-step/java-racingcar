package racing.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingInfo {

    private final List<String> carNames;
    private final int totalRoundNumber;

    public RacingInfo(String[] carNames, int totalRoundNumber) {
        this(Arrays.stream(carNames).collect(Collectors.toList()), totalRoundNumber);
    }

    public RacingInfo(List<String> carNames, int totalRoundNumber) {
        this.carNames = carNames;
        this.totalRoundNumber = totalRoundNumber;
    }

    public int getTotalRoundNumber() {
        return totalRoundNumber;
    }

    public List<String> getCarNames() {
        return carNames;
    }

}
