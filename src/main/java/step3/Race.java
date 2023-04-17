package step3;

import step3.numbergenerator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {

    private final int raceCount;
    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    private Race(int raceCount, List<Car> cars, NumberGenerator numberGenerator) {
        this.raceCount = raceCount;
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public static Race from(int raceCount, int carCount, NumberGenerator numberGenerator){
        List<Car> cars = new ArrayList<>(carCount);
        for(int i = 0; i < carCount; i++){
            cars.add(new Car());
        }

        return new Race(raceCount, cars, numberGenerator);
    }

    public int getRaceCount() {
        return raceCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void race(){
        for(int i = 0; i < raceCount; i++){
            raceCar();
        }
    }

    private void raceCar(){
        cars.forEach(car -> car.move(numberGenerator));
    }
}
