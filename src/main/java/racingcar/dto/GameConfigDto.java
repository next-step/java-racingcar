package racingcar.dto;

public class GameConfigDto {

    private final int numberOfCars;
    private final int maxOfRound;

    public GameConfigDto(int maxOfCars, int maxOfRound) {
        isPositiveNumber(maxOfCars);
        isPositiveNumber(maxOfRound);

        this.numberOfCars = maxOfCars;
        this.maxOfRound = maxOfRound;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getMaxOfRound() {
        return maxOfRound;
    }

    private void isPositiveNumber(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("0또는 음수값은 올 수 없어요.");
        }
    }

}
