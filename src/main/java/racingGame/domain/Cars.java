package racingGame.domain;

import java.util.ArrayList;
import java.util.List;


public class Cars {
    private static final String CARS_NULL_ERROR_MESSAGE = "자동차를 생성해주세요";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        carsNullChk(cars);
        this.cars = cars;
    }

    public List<Car> getList(){
        return this.cars;
    }

    private void carsNullChk(List<Car> cars){
        if(cars.isEmpty()){
            throw new NullPointerException(CARS_NULL_ERROR_MESSAGE);
        }
    }

    public static Cars makeCarList(int count) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++){
            cars.add(new Car());
        }
        return new Cars(cars);
    }

}
