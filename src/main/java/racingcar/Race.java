package racingcar;

import positiveinteger.PositiveInteger;
import racingcar.car.Car;
import racingcar.car.CarResource;
import racingcar.numbergenerator.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Race {

    private final PositiveInteger raceCount;
    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    private Race(PositiveInteger raceCount, List<Car> cars, NumberGenerator numberGenerator) {
        this.raceCount = raceCount;
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public static Race from(int raceCount, CarResource carResource, NumberGenerator numberGenerator){
        PositiveInteger positiveRaceCount = PositiveInteger.from(raceCount);
        List<Car> cars = createCars(carResource);

        return new Race(positiveRaceCount, cars, numberGenerator);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void race(){
        for(int i = 0; i < raceCount.getValue(); i++){
            raceCar();
        }
    }

    private void raceCar(){
        cars.forEach(car -> car.move(numberGenerator));
    }

    private static List<Car> createCars(CarResource carResource){
        return carResource.getCars().stream().map(Car::from).collect(Collectors.toList());
    }
}
