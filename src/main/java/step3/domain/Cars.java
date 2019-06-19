package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars makeCars(CarNameList list) { //TODO: Q. 이 메서드도 불변 컬렉션에 위반되는 메서드인가요?
        List<Car> cars = new ArrayList<>();
        for (String carName : list.getCarNameList()) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }


}
