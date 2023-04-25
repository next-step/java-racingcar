package racingcar.car;

import racingcar.CarDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final List<CarDto> winners;

    public Winners(List<Car> winners) {
        this.winners = winners.stream()
                .map(CarDto::new)
                .collect(Collectors.toList());
    }

    public List<CarDto> winners() {
        return new ArrayList<>(this.winners);
    }
}
