package step3;

import java.util.ArrayList;
import java.util.List;

public class CarResultDto {

    private List<CarDto> carDtoList;
    private List<String> winnerCarNames;

    public CarResultDto(List<Car> carList, List<String> winnerCarNames) {
        this.carDtoList = new ArrayList<>();

        for (Car car : carList) {
            this.carDtoList.add(new CarDto.Builder()
                    .carName(car.getCarName())
                    .position(car.getCurrentPosition())
                    .build()
            );
        }

        this.winnerCarNames = winnerCarNames;
    }

    public List<CarDto> getCarDtoList() {
        return this.carDtoList;
    }

    public List<String> getWinnerCarNames() {
        return this.winnerCarNames;
    }

}
