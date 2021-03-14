package step3;

import java.util.ArrayList;
import java.util.List;

public class CarResultDto {

    private List<CarDto> carDtoList;

    public CarResultDto(List<Car> carList) {
        this.carDtoList = new ArrayList<>();

        for (Car car : carList) {
            this.carDtoList.add(new CarDto.Builder()
                    .carName(car.getCarName())
                    .position(car.getCurrentPosition())
                    .build()
            );
        }
    }

    public List<CarDto> getCarDtoList() {
        return this.carDtoList;
    }
}
