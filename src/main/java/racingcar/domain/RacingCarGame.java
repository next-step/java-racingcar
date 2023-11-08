package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleRacingCarGame {

        private final String[] carNames;
        public SimpleRacingCarGame(String[] carNames) {
                this.carNames = carNames;
        }

        public List<Car> joinCars() {
                return IntStream.range(0, carNames.length).mapToObj(idx -> new Car(carNames[idx]))
                        .collect(Collectors.toList());
        }

        public void moveOneRound(List<Car> cars) {
                cars.forEach(Car::movedForwardIfCan);
        }

        public List<Car> findWinners(List<Car> cars) {
                int maxPosition = getMaxPosition(cars);
                return cars.stream().filter(car -> car.getCurrentPosition() == maxPosition).collect(Collectors.toList());
        }

        public int getMaxPosition(List<Car> cars){
                return cars.stream().max(Comparator.comparingInt(Car::getCurrentPosition)).get().getCurrentPosition();
        }

}
