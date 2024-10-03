package carracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {
    private static final Random RANDOM = new Random();
    private List<Car> cars;
    private final int moveTryCount;
    private final CarsMoveStatusHistory carsMoveStatusHistory;
    private int playCount;

    public CarRacing(int carCount, int moveTryCount) {
        this.createRaceCars(carCount);
        this.moveTryCount = moveTryCount;
        this.carsMoveStatusHistory = new CarsMoveStatusHistory();
        this.playCount = 0;
    }

    private void createRaceCars(int carCount) {
        this.cars = new ArrayList<>(carCount);
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMoveTryCount() {
        return moveTryCount;
    }

    public int getPlayCount() {
        return playCount;
    }

    public CarsMoveStatusHistory getCarsMoveStatusHistory() {
        return carsMoveStatusHistory;
    }

    public void start() {
        for (int i = 0; i < this.moveTryCount; i++) {
            this.moveCarsWithRandom();
            this.playCount += 1;
            this.carsMoveStatusHistory.save(this.cars);
        }
        ResultView.printCarRacingResult(this.carsMoveStatusHistory);
    }

    private void moveCarsWithRandom() {
        for (Car car : this.cars) {
            car.move(RANDOM.nextInt(10));
        }
    }

    public boolean isFinish() {
        return this.playCount == this.moveTryCount;
    }
}
