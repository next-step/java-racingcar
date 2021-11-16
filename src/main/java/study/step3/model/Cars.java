package study.step3.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static int START_CAR_NUMBER = 0;

    private List<Car> cars;

    /**
     * 자동차 수에 따라 Car List 생성
     */
    public Cars(int carCount){
        List<Car> cars = new ArrayList<>();
        for (int i = START_CAR_NUMBER; i < carCount; i++) {
            Car car = new Car();
            cars.add(car);
        }
        this.cars = cars;
    }

    /**
     * 시도 횟수별 자동차 리스트 조회
     * @return 자동차 리스트
     */
    public List<Car> getCars(){
        return this.cars;
    }

}
