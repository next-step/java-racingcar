package racingcar.dto;

public class GameConfigDto {

    private final int maxOfRound;
    private final int maxOfCars;

    public GameConfigDto(int maxOfRound, int maxOfCars) {
        this.maxOfRound = maxOfRound;
        this.maxOfCars = maxOfCars;
    }
}
