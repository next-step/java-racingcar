package step3.dto;

import step3.Position;

public class PositionResponse {
    private final int value;

    public PositionResponse(Position position) {
        this.value = position.getValue();
    }

    public int getValue() {
        return value;
    }
}
