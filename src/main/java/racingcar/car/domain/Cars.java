package racingcar.car.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.domain.winnerstrategy.WinnerStrategy;

/**
 * Car 컬렉션을 관리하는 일급 컬렉션
 */
public class Cars {

    private final List<Car> list;

    /**
     * 자동차 이름으로부터 Car 컬렉션을 생성한다.
     *
     * @param names 자동차 이름
     */
    public Cars(String[] names) {
        list = Arrays.stream(names)
            .map(Car::new)
            .collect(Collectors.toList());
    }

    /**
     * 0 이상 10 미만의 랜덤값을 생성하여, 값에 따라 자동차를 이동시킨다.
     */
    public void move() {
        for (Car car : list) {
            car.move(new RandomInt());
        }
    }

    /**
     * 우승자 선출 전략에 따라 경주 우승자를 선출한다.
     *
     * @param winnerStrategy 우승자 선출 전략
     * @return 우승한 Car 리스트
     */
    public List<Car> getWinners(WinnerStrategy winnerStrategy) {
        return winnerStrategy.getWinners(list);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(list);
    }
}
