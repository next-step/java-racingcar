package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

        public static List<Car> findWinners(List<Car> cars) {
                int maxPosition = getMaxPosition(cars);
                return cars.stream().filter(car -> car.currentPosition().isSamePosition(maxPosition))
                    .collect(Collectors.toList());
        }

        private static int getMaxPosition(List<Car> cars) {
                Positions positions = new Positions(
                    cars.stream().map(car -> car.currentPosition()).collect(Collectors.toList()));
                return positions.getMaxPosition();
        }
}
