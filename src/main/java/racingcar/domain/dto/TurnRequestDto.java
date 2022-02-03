package racingcar.domain.dto;

import racingcar.domain.car.Turn;

public class TurnRequestDto {

    private String value;

    public TurnRequestDto(String value) {
        this.value = value;
    }

    public Turn toEntity() {
        return Turn.createTurn(this.value);
    }
}
