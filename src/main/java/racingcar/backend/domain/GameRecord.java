package racingcar.backend.domain;

import racingcar.backend.dto.CarDto;

import java.util.List;

public class GameRecord {

    private List<CarDto> carDtos;

    public GameRecord(List<CarDto> carDtos) {
        this.carDtos = carDtos;
    }

    public static GameRecord create(List<CarDto> carDtos) {
        return new GameRecord(carDtos);
    }

    public List<CarDto> getValue() {
        return carDtos;
    }
}
