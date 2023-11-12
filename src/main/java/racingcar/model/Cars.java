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

        public List<Car> getCars() {
                return cars;
        }
}
