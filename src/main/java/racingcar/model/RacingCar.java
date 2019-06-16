package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCar {

    private int time;
    private List<Car> cars;
    private Mover<Car> mover;

    public static RacingCar of(int time, int carCount, Mover<Car> mover) {
        List<Car> cars = IntStream.rangeClosed(1, carCount).mapToObj(value -> new Car()).collect(Collectors.toList());
        return new RacingCar(time, cars, mover);
    }

    public static RacingCar generate(int time, int carCount){
        return of(time, carCount, new RandomCarMover());
    }

    RacingCar(int time, List<Car> cars, Mover mover) {
        this.time = time;
        this.cars = cars;
        this.mover = mover;
    }

    public List<Car> play(){
        time --;
        for (Car car : cars) {
            mover.move(car);
        }
        return cars;
    }

    public boolean isGameOver() {
        return time == 0;
    }
}
