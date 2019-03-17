package racingcar.view.dto;

import java.util.List;

public class CarsResponseDto {
    List<CarResponseDto> carResponseDtos;

    public CarsResponseDto(List<CarResponseDto> carResponseDtos) {
        this.carResponseDtos = carResponseDtos;
    }

    public List<CarResponseDto> getCarResponseDtos() {
        return carResponseDtos;
    }
}
