package racingcar.car;

import racingcar.numbergenerator.NumberGenerator;
import racingcar.printer.RacePrinter;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    public RacingCars(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public void raceCar(){
        cars.forEach(car -> car.move(numberGenerator));
        RacePrinter.printPerRound(cars);
    }

    public List<Car> getWinners(){
        int maxState = cars.stream().mapToInt(Car::getState).max().orElse(0);

        return cars.stream()
                .filter(car -> car.getState() == maxState)
                .collect(Collectors.toList());
    }

}
