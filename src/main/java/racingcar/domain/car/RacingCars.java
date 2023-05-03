package racingcar.domain.car;

import racingcar.domain.numbergenerator.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    public RacingCars(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public RacingCars copy(RacingCars racingCars){
        List<Car> cars = racingCars.getCars().stream()
                .map(Car::copy)
                .collect(Collectors.toList());

        return new RacingCars(cars, racingCars.numberGenerator);
    }

    public void raceCar(){
        cars.forEach(car -> car.move(numberGenerator));
    }

    public List<Car> getCars(){
        return cars;
    }

    public List<Car> getWinners(){
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toList());
    }

}
