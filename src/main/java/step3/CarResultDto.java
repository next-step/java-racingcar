package step3;

import java.util.ArrayList;
import java.util.List;

public class CarResultDto {

    private List<Car> carResultList;

    public CarResultDto(List<Car> carList) {
        this.carResultList = new ArrayList<>();

        for (Car car : carList) {
            this.carResultList.add(new Car(car.getCurrentPosition()));
        }
    }

    public List<Car> getCarResultList() {
        return this.carResultList;
    }
}
