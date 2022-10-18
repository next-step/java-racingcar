package racingcar.dto;

import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class RoundResultDto {
    public final List<Integer> positions;

    public final List<String> names;

    public RoundResultDto(Cars cars) {
        this.names = cars.getCarNames();
        this.positions = cars.getPositions();
    }

    public List<CarResultDto> getResults() {
        List<CarResultDto> carResultDtos = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            carResultDtos.add(new CarResultDto(names.get(i), positions.get(i)));
        }
        return carResultDtos;
    }
}
