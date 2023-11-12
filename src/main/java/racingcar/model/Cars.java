package racingcar.model;

import java.util.List;

public class Cars {

        private final List<Car> cars;

        public Cars(List<Car> cars) {
                this.cars = cars;
        }

        public List<Car> findWinners() {
                return Winners.findWinners(cars);
        }

        public void moveOneRound(int randomNumber) {
                cars.forEach(car -> {
                        car.movedForwardIfCan(randomNumber);
                });
        }

        public List<Car> getCars() {
                return cars;
        }
}
