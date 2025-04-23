package step3.dto;

import java.util.List;

public class RaceRoundResult {
    private final List<PositionResponse> value;

    public RaceRoundResult(List<PositionResponse> value) {
        this.value = value;
    }

    public List<PositionResponse> getValue() {
        return value;
    }
}
