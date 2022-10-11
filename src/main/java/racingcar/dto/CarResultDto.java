package racingcar.dto;

import racingcar.domain.Car;

import java.util.Objects;

public class CarResultDto {
    public String name;
    public int position;

    public CarResultDto(String name, int position) {
        this.name = name;
        this.position = position;
    }
}
