package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFacility {

    public CarFacility() {
    }

    public List<Car> buildCar(int carNum) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            carList.add(new Car());
        }
        return carList;
    }


}
