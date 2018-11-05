package racing.dto;

import java.util.List;

public class RacingGameCreateRequest {
    private List<String> carNames;
    private int time;

    public RacingGameCreateRequest(List<String> carNames, int time) {
        this.carNames = carNames;
        this.time = time;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getTime() {
        return time;
    }
}
