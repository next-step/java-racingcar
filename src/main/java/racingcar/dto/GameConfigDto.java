package racingcar.dto;

public class GameConfigDto {

    private final int numberOfCars;
    private final int maxOfRound;

    public GameConfigDto(int maxOfCars, int maxOfRound) {
        this.numberOfCars = maxOfCars;
        this.maxOfRound = maxOfRound;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getMaxOfRound() {
        return maxOfRound;
    }

}
