/*
 * 자동차 경주의 자동차 집합을 담당하는 클래스
 *
 * @author hj-woo
 * @version 2.0
 * */
package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(List<Car> carList) {
        this.cars = carList;
    }

    /*
     * 자동차들의 전진한 횟수를 확인하여 리스트로 반환한다.
     * @param null
     * @return 자동차들의 전진한 횟수를 담은 리스트, LinkedList<Integer>
     * */
    public ArrayList<Position> checkMove() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Map<Name, Position> checkCarStatus() {
        return cars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getPosition, (name, num) -> name, TreeMap::new));
    }

    public void tryMove() {
        cars.forEach(Car::move);
    }
}
