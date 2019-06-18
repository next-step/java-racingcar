package RacingGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Racing {

    private int time;
    private List<Car> cars;
    private OutputView outputView;

    public Racing(int time, int inputCountCar) {
        this.time = time;
        this.cars = this.arrayWithCar(inputCountCar);
        this.outputView = new OutputView();
    }

    public int getTime() {
        return time;
    }

    private List<Car> arrayWithCar(int carCount) {
        ArrayList<Car> cars = new ArrayList<>(carCount);
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void raceCarMoveLoop() {
        for (Car car : this.cars) {
            car.nextRace();
        }
    }

    public void raceStart() {
        for (int i = 0; i < this.time; i++) {
            this.raceCarMoveLoop();
            outputView.printRace(this.cars);
        }
    }

    public List<String> splitCarNames(String names) {
        return Arrays.asList(names.split(","));
    }
}
