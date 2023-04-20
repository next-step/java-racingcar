package study.racingcar.domain;

import study.racingcar.dto.CarDto;

import java.util.List;
import java.util.stream.Collectors;

public class GameWinner {

    private int maxPosition;
    private List<CarDto> carDtos;

    public GameWinner(List<CarDto> carDtos) {
        this.maxPosition = getMaxPosition(carDtos);
        this.carDtos = carDtos;
    }

    public int getMaxPosition(List<CarDto> carDtos) {

        return carDtos.stream()
                .map(CarDto::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }

    public List<String> findGameWinner() {

        return this.carDtos.stream()
                .filter(carDto -> carDto.getPosition() == maxPosition)
                .map(CarDto::getName)
                .collect(Collectors.toList());
    }
}
