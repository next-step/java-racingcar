package carracing.domain;

import java.util.ArrayList;
import java.util.List;

public class CarCompany {
    public List<Car> createCar(String carNames) {
        String[] arrCarNames = splitCarName(carNames);
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < arrCarNames.length; i++) {
            //이름 길이 5글자로 제한
            checkNameNumber(arrCarNames[i]);
        }
        return cars;
    }

    public void checkNameNumber(String carName) {
        if(carName.length() > 5) {
            throw new RuntimeException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public String[] splitCarName(String carNames) {
        String[] arrCarNames = carNames.split(",");
        return arrCarNames;
    }
}
