package racingcar.step3.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created : 2020-11-12 오전 10:20
 * Developer : Seo
 */
public class Cars {
    private final List<Car> carList;

    public Cars(String carsName) {
        this.carList = new ArrayList<>();
        String[] arrCarsName = carsName.split(",");
        for (String carName : arrCarsName) {
            this.carList.add(new Car(carName));
        }
    }

    public List<Car> getCars() {
        return this.carList;
    }

}
