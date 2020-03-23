package racingcar.dto;

public class RacingCarRequestDto {
    private String racingCarNames;
    private int numberOfTime;

    public RacingCarRequestDto(String racingCarNames, int numberOfTime) {
        this.racingCarNames = racingCarNames;
        this.numberOfTime = numberOfTime;
    }

    public String getRacingCarNames() {
        return racingCarNames;
    }

    public int getNumberOfTime() {
        return numberOfTime;
    }
}
