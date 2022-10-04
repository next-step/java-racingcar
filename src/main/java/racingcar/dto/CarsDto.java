package racingcar.dto;

import java.util.List;

public class CarsDto {
    private final List<CarDto> values;

    public CarsDto(List<CarDto> values) {
        this.values = values;
    }

    public List<CarDto> getValues() {
        return values;
    }
}
