package step3.race;

import step3.model.Cars;

public class Race {

    private int raceTimes;

    private Cars cars;

    public Race(int carCounts, int raceTimes) {
        this.raceTimes = raceTimes;
        cars = new Cars(carCounts);
    }

    public void doRace(boolean move){
        cars.getCars().stream().forEach(car -> car.move(move));
    }

    public Cars getCars(){
        return this.cars;
    }
}
