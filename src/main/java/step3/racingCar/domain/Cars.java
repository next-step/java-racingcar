/*
 * 자동차 경주의 자동차 집합을 담당하는 클래스
 *
 * @author hj-woo
 * @version 1.0
 * */
package step3.racingCar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    public ArrayList<Integer> checkForward() {
        return cars.stream()
                .map(Car::getForwardNum)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Map<String, Integer> checkCarStatus() {
        return cars.stream()
                .collect(Collectors.toMap(
                        Car::getName, Car::getForwardNum)
                );
    }

    public void tryForward() {
        cars.forEach(Car::goForward);
    }
}
