package step3;

import java.util.ArrayList;
import java.util.List;

public class CarResultDto {

    private List<CarPosition> carPositionList;
    private List<String> winnerCarNames;

    public CarResultDto(List<Car> carList, List<String> winnerCarNames) {
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

    public List<CarPosition> getCarDtoList() {
        return this.carPositionList;
    }

    public List<String> getWinnerCarNames() {
        return this.winnerCarNames;
    }

}
