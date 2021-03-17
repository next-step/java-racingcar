package carracing.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private final List<Car> carList;

    public Winners(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<String> getNameList() {
        List<String> nameList = new ArrayList<>();
        for (Car car : carList) {
            nameList.add(car.inquiryRacingScore().getCarName());
        }
        return nameList;
    }
}
