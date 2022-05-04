package racingcar.domain;

import java.util.List;

public class Winners {

    private final List<Car> winners;

    public Winners(List<Car> cars) {
        validatePosition(cars);
        this.winners = cars;
    }

    private void validatePosition(List<Car> cars) {
        Position position = new Cars(cars).getMaxPosition();
        for (Car car : cars) {
            if (!car.isEqualPosition(position)) {
                throw new IllegalStateException("우승자의 이동 거리가 같지 않습니다.");
            }
        }
    }

    public List<Car> getWinners() {
        return this.winners;
    }
}
