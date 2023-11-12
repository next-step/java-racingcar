package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

class Winners {

        static List<Car> findWinners(List<Car> cars) {
                Position maxPosition = getMaxPosition(cars);
                return cars.stream().filter(car -> car.currentPosition().isSamePosition(maxPosition))
                    .collect(Collectors.toList());
        }

        private static Position getMaxPosition(List<Car> cars) {
                Positions positions = new Positions(
                    cars.stream().map(car -> car.currentPosition()).collect(Collectors.toList()));
                return positions.getMaxPosition();
        }
}
