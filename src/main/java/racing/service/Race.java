package racing.service;


import racing.domain.Cars;
import racing.domain.Winners;

public class Race {

    private final Cars cars;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public void startMoving(){
        cars.move();
    }

    public Cars getCars() {
        return cars;
    }

    public Winners getWinners(){
        return cars.findWinners();
    }
}