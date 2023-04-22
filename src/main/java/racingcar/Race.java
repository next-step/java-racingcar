package racingcar;

import positiveinteger.PositiveInteger;
import racingcar.numbergenerator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final PositiveInteger raceCount;
    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    private Race(PositiveInteger raceCount, List<Car> cars, NumberGenerator numberGenerator) {
        this.raceCount = raceCount;
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public static Race from(int raceCount, int carCount, NumberGenerator numberGenerator){
        PositiveInteger positiveRaceCount = PositiveInteger.from(raceCount);
        PositiveInteger positiveCarCount = PositiveInteger.from(carCount);
        List<Car> cars = new ArrayList<>(carCount);
        for(int i = 0; i < positiveCarCount.getValue(); i++){
            cars.add(new Car());
        }

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
}
