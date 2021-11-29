package racing.refactor.dto;

import java.util.List;

public class RequestGameCreation {

    private List<String> carNames;
    private int loopCount;

    public RequestGameCreation(List<String> carNames, int loopCount) {
        this.carNames = carNames;
        this.loopCount = loopCount;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getLoopCount() {
        return loopCount;
    }

    public int getCarCount() {
        return carNames.size();
    }
}
