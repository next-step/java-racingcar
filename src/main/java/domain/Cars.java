package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    /**
     * 위치가 커스터마이징된 차량으로 차량 생성
     */
    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    /**
     * 초기 이름을 받아서 차량 생성
     */
    public Cars(String names) {
        this(Arrays.stream(names.split(","))
            .map(Car::new)
            .collect(Collectors.toList()));
    }

    public int size() {
        return cars.size();
    }

    /**
     * 차량 중 가장 먼 차량의 위치 반환 메서드
     */
    public int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPositionValue)
            .reduce(0, Integer::max);
    }

    /**
     * 차량 중 같은 위치에 있는 차량을 반환하는 메서드
     */
    public List<Car> getCarsWithSamePosition(int number) {
        return cars.stream()
            .filter(car -> car.isSamePosition(number))
            .collect(Collectors.toList());
    }
}
