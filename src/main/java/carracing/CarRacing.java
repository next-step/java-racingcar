package carracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {
    private static final Random RANDOM = new Random();
    private final List<Car> cars;
    private final int moveTryCount;
    private final CarsMoveStatusHistory carsMoveStatusHistory;
    private int playCount;

    private CarRacing(List<Car> cars, int moveTryCount, CarsMoveStatusHistory carsMoveStatusHistory, int playCount) {
        this.cars = cars;
        this.moveTryCount = moveTryCount;
        this.carsMoveStatusHistory = carsMoveStatusHistory;
        this.playCount = playCount;
    }

    public static CarRacingBuilder builder() {
        return new CarRacingBuilder();
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


    public static class CarRacingBuilder {
        private List<Car> cars;
        private int moveTryCount;
        private final int playCount = 0;
        private final CarsMoveStatusHistory carsMoveStatusHistory = new CarsMoveStatusHistory();

        protected CarRacingBuilder() {
        }

        public CarRacingBuilder cars(int carCount) {
            this.cars = new ArrayList<>(carCount);
            for (int i = 0; i < carCount; i++) {
                cars.add(new Car());
            }
            return this;
        }

        public CarRacingBuilder moveTryCount(int moveTryCount) {
            this.moveTryCount = moveTryCount;
            return this;
        }

        public CarRacing build() {
            return new CarRacing(this.cars, this.moveTryCount, this.carsMoveStatusHistory, this.playCount);
        }
    }
}
