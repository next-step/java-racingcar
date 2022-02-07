package racingcar.dto;

import racingcar.domain.car.Turn;

public class TurnRequestDto {

    private final String value;

    public TurnRequestDto(final String value) {
        this.value = value;
    }

    public Turn toEntity() {
        return Turn.createTurn(this.value);
    }
}
