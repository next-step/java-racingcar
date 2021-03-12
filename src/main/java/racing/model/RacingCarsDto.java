package racing.model;

import java.util.List;

public class RacingCarsDto {
    private List<RacingCarDto> carList;

    public RacingCarsDto(List<RacingCarDto> carList) {
        this.carList = carList;
    }

    public List<RacingCarDto> getCarList() {
        return carList;
    }
}
