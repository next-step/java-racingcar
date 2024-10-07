package racingCar.step5.domain.dto;

import racingCar.step5.domain.RacingCar;

import java.util.Objects;

public class WinnerDto {
    private String carName;
    public WinnerDto(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public static WinnerDto of(RacingCar winnerCar){
        return new WinnerDto(winnerCar.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinnerDto winnerDto = (WinnerDto) o;
        return Objects.equals(carName, winnerDto.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(carName);
    }
}
