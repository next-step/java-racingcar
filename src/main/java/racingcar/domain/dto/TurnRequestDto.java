package racingcar.domain.dto;

import racingcar.domain.car.Turn;

public class TurnRequestDto {

    private String value;

    public TurnRequestDto(String value) {
        this.value = value;
    }

    public static Turn toEntity(TurnRequestDto turnRequestDto) {
        return new Turn(turnRequestDto.value);
    }
}
