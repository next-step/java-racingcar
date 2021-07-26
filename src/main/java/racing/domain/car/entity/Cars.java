package racing.domain.car.entity;

import racing.domain.car.vo.Location;
import racing.domain.car.vo.fuel.Fuel;
import racing.domain.game.vo.Turn;

import java.util.*;

public class Cars implements Iterable<Car> {
    private final Set<Car> values;

    public Cars(Set<Car> values) {
        this.values = values;
    }

    public void moveAll(Turn turn, Fuel fuel) {
        for (Car iCar : this) {
            Location resultLocation = iCar.move(fuel);
            turn.register(iCar, resultLocation);
        }
    }

    /* 테스트가 필요한 Foward 메소드들 */
    public void add(Car car) {
        if (values.contains(car))
            throw new IllegalStateException("중복된 자동차 이름이 존재 합니다.");
        values.add(car);
    }

    /* 단순 Forward 메소드들 (테스트 X) */
    public boolean isEmpty() {
        return values.isEmpty();
    }

    public int size() {
        return values.size();
    }

    @Override
    public Iterator<Car> iterator() {
        return values.iterator();
    }
}
