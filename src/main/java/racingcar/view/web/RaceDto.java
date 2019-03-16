package racingcar.view.web;

import java.util.List;

public class RaceDto {
    private String name;
    private List<RacingCarDto> cars;

    public RaceDto(String name, List<RacingCarDto> cars) {
        this.name = name;
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public List<RacingCarDto> getCars() {
        return cars;
    }
}
