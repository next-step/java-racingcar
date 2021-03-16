package step4.domain.dto;

import step4.domain.driver.Driver;

import java.util.ArrayList;
import java.util.List;

public class RacingCarResponseDto {
    private List<Driver> racingRecords;

    private RacingCarResponseDto() {
        racingRecords = new ArrayList<>();
    }

    public static RacingCarResponseDto newInstance() {
        return new RacingCarResponseDto();
    }

    public void add(List<Driver> nextRecords) {
        racingRecords.addAll(nextRecords);
    }

    public List<Driver> getRacingRecords() {
        return racingRecords;
    }
}
