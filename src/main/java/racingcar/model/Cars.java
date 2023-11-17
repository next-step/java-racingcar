package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

        private final List<Car> values;

        public Cars(List<Car> values) {
                this.values = values;
        }

        public List<Car> values() {
                return values;
        }

        public List<Car> findWinners() {
                Position maxPosition = getMaxPosition(values);
                return values.stream().filter(car -> car.currentPosition().isSamePosition(maxPosition))
                    .collect(Collectors.toList());
        }

        private Position getMaxPosition(List<Car> cars) {
                Positions positions = new Positions(
                    cars.stream().map(Car::currentPosition).collect(Collectors.toList()));
                return positions.getMaxPosition();
        }
}
