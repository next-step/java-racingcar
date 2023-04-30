package racing;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public List<CarDTO> startGame(MoveStrategy moveStrategy) {
        cars.move(moveStrategy);
        return cars.getCarDTOs();
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
