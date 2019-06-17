package RacingGame;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private int time;
    private List<Car> cars;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<Car> arrayWithCar(int carCount) {
        ArrayList<Car> cars = new ArrayList<>(carCount);
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void raceCarMoveLoop() {
        for (Car car : this.cars){
            car.nextRace();
        }
    }
}
