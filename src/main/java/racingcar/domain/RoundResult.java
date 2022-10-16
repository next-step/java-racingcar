package racingcar.domain;

import racingcar.dto.CarResultDto;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {
    private final List<Integer> positions;

    private final List<String> names;

    public RoundResult(Cars cars) {
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
