package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRacingResult {

    private final List<CarPosition> carPositionList;
    private final List<String> winnerCarNames;

    public CarRacingResult(List<Car> carList, List<String> winnerCarNames) {
        this.carPositionList = new ArrayList<>();

        for (Car car : carList) {
            this.carPositionList.add(new CarPosition.Builder()
                    .carName(car.getCarName())
                    .position(car.getCurrentPosition())
                    .build()
            );
        }

        this.winnerCarNames = winnerCarNames;
    }

    public List<CarPosition> getCarPositionList() {
        return this.carPositionList;
    }

    public List<String> getWinnerCarNames() {
        return this.winnerCarNames;
    }

}
