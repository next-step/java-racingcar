package step5.domain;

import java.util.Set;
import java.util.stream.Collectors;

public class Race {

    private Cars cars;

    public void setUpRace(String[] carNames) {
        this.cars = new Cars(carNames);
    }

    public Set<CarDto> runOneRound() {
        Set<Car> movedCars = cars.moveCars();

        return movedCars.stream()
                .map(CarDto::new)
                .collect(Collectors.toSet());
    }

    public Set<CarDto> getWinnersNames() {
        return cars.getWinningCarNames();
    }

}
