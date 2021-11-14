package study.step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static int START_CAR_NUMBER = 0;

    private List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = cars;
    }

    /**
     * 자동차 수에 따라 Car List 생성
     * @return
     */
    private static List<Car> generateCars(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = START_CAR_NUMBER; i < carCount; i++) {
            Car car = new Car();
            carList.add(car);
        }
        return carList;
    }
}
