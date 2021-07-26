package racing.domain.car.entity;

import racing.domain.car.vo.fuel.Fuel;
import racing.domain.game.dto.Turn;

import java.util.*;

public class Cars implements Iterable<Car> {
    private final Set<Car> values;

    public Cars(Set<Car> values) {
        this.values = values;
    }

    public Cars() {
        this(new HashSet<>());
    }

    public void moveAll(Turn turn, Fuel fuel) {
        for (Car iCar : this) {
            iCar.move(turn, fuel);
        }
    }

    /* 테스트가 필요한 Foward 메소드들 */
    public void add(Car car) {
        if (values.contains(car))
            throw new IllegalStateException("중복된 자동차 이름이 존재 합니다.");
        values.add(car);
    }

    public void addAll(Cars cars) {
        for (Car iCar : cars)
            add(iCar);
    }

    /* 단순 Forward 메소드들 (테스트 X) */
    public boolean isEmpty() {
        return values.isEmpty();
    }

    public boolean contains(Car car) {
        return values.contains(car);
    }

    public int size() {
        return values.size();
    }

    @Override
    public Iterator<Car> iterator() {
        return values.iterator();
    }
}
