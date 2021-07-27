package racing.domain.car;

import racing.domain.fuel.Fuel;
import racing.domain.Location;
import racing.domain.Turn;

import java.util.*;

public class Cars implements Iterable<Car> {
    private final Set<Car> values;

    public Cars(Set<Car> values) {
        this.values = values;
    }

    public Turn moveAll(Fuel fuel) {
        Map<Car, Location> result = new HashMap<>();
        for (Car iCar : this) {
            Location resultLocation = iCar.move(fuel);
            result.put(iCar, resultLocation);
        }
        return new Turn(result);
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
