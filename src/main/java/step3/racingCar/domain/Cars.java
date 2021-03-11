package step3.racingCar.domain;
/*
 * 자동차 경주의 자동차 집합을 담당하는 클래스
 *
 * @author hj-woo
 * @version 1.0
 * */

import java.util.LinkedList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars() {
        this.cars = new LinkedList<Car>();
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    /*
    * 자동차들의 전진한 횟수를 확인하여 리스트로 반환한다.
    * @param null
    * @return 자동차들의 전진한 횟수를 담은 리스트, LinkedList<Integer>
    * */
    public LinkedList<Integer> checkForward(){
        LinkedList<Integer> forwardNums = new LinkedList<>();
        cars.stream().forEach(car -> {
            forwardNums.add(car.getForwardNum());
        });
        return forwardNums;
    }

    public void tryForward(){
        cars.stream().forEach(car -> car.goForward());
    }
}
