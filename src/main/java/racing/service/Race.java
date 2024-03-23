package racing.service;


import racing.domain.Cars;
import racing.domain.Winners;
import racing.util.NumberGenerator;
import racing.util.RandomNumberGenerator;

public class Race {

    private final Cars cars;

    private NumberGenerator numberGenerator = new RandomNumberGenerator();

    public Race(Cars cars) {
        this.cars = cars;
    }

    public Race(Cars cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public void startMoving(){
        cars.move(numberGenerator.generate());
    }

    public Cars getCars() {
        return cars;
    }

    public Winners getWinners(){
        return cars.findWinners();
    }
}