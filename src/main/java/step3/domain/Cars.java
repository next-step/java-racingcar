package step3.domain;

import java.util.List;

public class Cars {
    private static final int CARS_MIN_COUNT = 1;
    private final List<Car> cars ;

    public Cars(List<Car> cars) {
        validateSize(cars);
        this.cars = cars;
    }

    private void validateSize(List<Car> cars) {
        if(cars.size() < CARS_MIN_COUNT){
            throw new OutBoundCarListSizeException();
        }
    }

    public int getCarsCount(){
        return this.cars.size();
    }


}
