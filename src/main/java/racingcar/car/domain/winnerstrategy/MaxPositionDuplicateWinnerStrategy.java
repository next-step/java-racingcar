package racingcar.car.domain.winnerstrategy;

import racingcar.car.domain.Car;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 게임 우승자 선출 전략.
 * - 가장 먼 거리를 이동한 참가자를 우승자로 선정한다
 * - 우승자는 한 명 이상일 수 있다
 */
public class MaxPositionDuplicateWinnerStrategy implements WinnerStrategy {

    /**
     * position 값이 가장 큰 Car 를 우승자로 선정한다.
     *
     * @param cars 게임에 참가한 자동차 리스트
     * @return 우승한 자동차 리스트
     */
    @Override
    public List<Car> getWinners(List<Car> cars) {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new IllegalArgumentException("자동차 리스트는 비어있을 수 없습니다."));

        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .collect(Collectors.toList());
    }
}
