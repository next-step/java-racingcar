package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRoundResult {

    private final List<CarPosition> carPositionList;

    public CarRoundResult(Cars cars) {
        this.carPositionList = new ArrayList<>();

        for (Car car : cars.getCars()) {
            this.carPositionList.add(new CarPosition.Builder()
                    .carName(car.getCarName())
                    .position(car.getCurrentPosition())
                    .build()
            );
        }
    }

    public List<CarPosition> getCarPositionList() {
        return this.carPositionList;
    }

}
