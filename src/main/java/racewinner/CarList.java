package racewinner;

import racewinner.expteion.CarNameTooLongException;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private List<Car> carList = new ArrayList<>();

    public void add(String name) {
        if (name.length() > 5) {
            throw new CarNameTooLongException("자동차의 이름은 5글자를 초과 할 수 없습니다.");
        }

        carList.add(new Car(name));
    }
}
