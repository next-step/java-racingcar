package racingCar.step5.domain.dto;

import java.util.Objects;

public class WinnerDto {
    private String carName;
    public WinnerDto(String carName) {
        this.carName = carName;
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
