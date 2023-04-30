package racing.domain.model;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.dto.CarDTO;
import racing.domain.move.MoveStrategy;

public class RacingGame {

    private final Cars cars;
    private final Integer round;
    private Integer currentRound;

    public RacingGame(Cars cars, Integer round) {
        this(cars, round, 0);
    }

    public RacingGame(Cars cars, Integer round, Integer currentRound) {
        this.cars = cars;
        this.round = round;
        this.currentRound = currentRound;
    }

    public List<CarDTO> startGame(MoveStrategy moveStrategy) {
        currentRound++;
        cars.move(moveStrategy);
        return cars.getCarDTOs();
    }

    public boolean isOver() {
        return round <= currentRound;
    }

    public List<CarDTO> getWinner() {
        Integer longDistance = cars.getCars()
            .stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(IllegalAccessError::new);

        return cars.getCarDTOs()
            .stream()
            .filter(carDTO -> carDTO.getPosition().equals(longDistance))
            .collect(Collectors.toList());
    }

}
