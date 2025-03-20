package car_racing2.view;

import java.util.List;

public class InputData {
    private final List<String> carNames;
    private final Integer numOfRounds;

    public InputData(List<String> carNames, Integer numOfRounds) {
        this.carNames = carNames;
        this.numOfRounds = numOfRounds;
    }

    public List<String> getCarNames() {
        return this.carNames;
    }

    public int getNumOfRounds() {
        return this.numOfRounds;
    }
}
