package com.nextlevel.kky.racing.dto;

import com.nextlevel.kky.racing.core.Car;

import java.util.List;
import java.util.Map;

public class CarRaceResultDto {

    public static class CarPositionDto {

        private final String carName;
        private final int position;

        public CarPositionDto(String carName, int position) {
            this.carName = carName;
            this.position = position;
        }

        public String getCarName() {
            return carName;
        }

        public int getPosition() {
            return position;
        }
    }

    public static class RoundResultDto {

        private final List<CarPositionDto> carPositionDtoList;

        public RoundResultDto(List<CarPositionDto> carPositionDtoList) {
            this.carPositionDtoList = carPositionDtoList;
        }

        public List<CarPositionDto> getCarPositionDtoList() {
            return carPositionDtoList;
        }
    }

    private List<RoundResultDto> racingResult;

    public CarRaceResultDto(List<RoundResultDto> racingResult) {
        this.racingResult = racingResult;
    }

    public List<RoundResultDto> getRacingResult() {
        return racingResult;
    }
}
