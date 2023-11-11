package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

        public static List<Car> findWinners(List<Car> cars) {
                int maxPosition = getMaxPosition(cars);
                return cars.stream().filter(car -> car.currentPosition().isAtPosition(maxPosition)).collect(Collectors.toList());
        }

        private static int getMaxPosition(List<Car> cars){
                int maxPosition = 0;
                for (Car car : cars) {
                        maxPosition = car.currentPosition().max(maxPosition);
                }
                return maxPosition;
        }

}
