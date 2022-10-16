package com.nextlevel.kky.racing.dto;

import java.util.List;

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

    private final List<RoundResultDto> racingResult;
    private final List<String> winnerNames;

    public CarRaceResultDto(List<RoundResultDto> racingResult, List<String> winnerNames) {
        this.racingResult = racingResult;
        this.winnerNames = winnerNames;
    }

    public List<RoundResultDto> getRacingResult() {
        return racingResult;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}
