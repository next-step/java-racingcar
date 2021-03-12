package racingcar.domain.dto;

import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingCarResponseDto {
    private List<Car> racingRecords;

    private RacingCarResponseDto() {
        racingRecords = new ArrayList<>();
    }

    public static RacingCarResponseDto newInstance() {
        return new RacingCarResponseDto();
    }

    public void add(List<Car> nextRecords) {
        racingRecords.addAll(nextRecords);
    }

    public List<Car> getRacingRecords() {
        return racingRecords;
    }
}
