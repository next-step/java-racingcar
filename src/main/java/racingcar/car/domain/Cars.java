package racingcar.car.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    public Cars(final String[] names) {
        list = Arrays.stream(names)
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public Cars(final List<Car> cars) {
        this.list = cars;
    }

    /**
     * 0 이상 10 미만의 랜덤값을 생성하여, 값에 따라 자동차를 이동시킨다.
     */
    public void move() {
        for (Car car : list) {
            car.move(new RandomInt());
        }
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition(list);

        return list.stream()
            .filter(car -> car.matchPosition(maxPosition))
            .collect(Collectors.toList());
    }

    private int getMaxPosition(final List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(list);
    }
}
