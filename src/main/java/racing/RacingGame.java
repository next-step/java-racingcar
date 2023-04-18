package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final Integer numberOfTry;

    private final Cars cars;

    public RacingGame(Integer numberOfTry, Cars cars) {
        this.numberOfTry = numberOfTry;
        this.cars = cars;
    }

    public List<List<CarDTO>> startGame(MoveStrategy moveStrategy) {
        List<List<CarDTO>> gameResult = new ArrayList<>();
        for (int i = 0; i < numberOfTry; i++) {
            cars.move(moveStrategy);
            gameResult.add(cars.getCarDTOs());
        }
        return gameResult;
    }

    public List<CarDTO> getWinner() {
        Integer longDistance = cars.getCarDTOs()
            .stream()
            .mapToInt(CarDTO::getPosition)
            .max()
            .orElseThrow(IllegalAccessError::new);

        return cars.getCarDTOs()
            .stream()
            .filter(carDTO -> carDTO.getPosition().equals(longDistance))
            .collect(Collectors.toList());
    }

}
