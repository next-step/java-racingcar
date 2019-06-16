package racingcar.model;

import java.util.List;

public class RacingCar {

    private int time;
    private Cars cars;
    private Mover<Car> mover;

    public static RacingCar generate(int time, int carCount){
        return of(time, carCount, new RandomCarMover());
    }

    public static RacingCar of(int time, int carCount, Mover<Car> mover) {
        Cars cars = Cars.generate(carCount);
        return new RacingCar(time, cars, mover);
    }

    private RacingCar(int time, Cars cars, Mover mover) {
        this.time = time;
        this.cars = cars;
        this.mover = mover;
    }

    public List<Car> ready(){
        return cars.init();
    }

    public List<Car> play(){
        time --;
        return cars.moveAll(mover);
    }

    public boolean isGameOver() {
        return time == 0;
    }
}