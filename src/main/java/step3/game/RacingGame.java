package step3.game;

import step3.car.Car;
import step3.car.RacingCar;

import java.util.ArrayList;
import java.util.List;

public abstract class RacingGame {
    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void deleteCar(Car car) {
        cars.remove(car);
    }

    public boolean hasCar(Car car) {
        return cars.contains(car);
    }

    public void notifyCars() {
        cars.forEach(c -> c.go(this));
    }

    public StringBuilder gameProgress(){
        StringBuilder sb = new StringBuilder();
        cars.forEach(c-> sb.append(((RacingCar)c).getSkidMark()).append(System.lineSeparator()));
        return sb;
    }

    public abstract Integer getNumber();

    public abstract void execute(RacingInfomation racingInfomation);
}
