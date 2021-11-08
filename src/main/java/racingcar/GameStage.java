package racingcar;

public class GameStage {

    private final int maxOfRound;
    private final Car[] cars;

    private GameStage(int maxOfRound, int numberOfCars) {
        inputValueValid(maxOfRound, numberOfCars);

        this.maxOfRound = maxOfRound;
        this.cars = new Car[numberOfCars];
    }

    public static GameStage start(int maxOfRound, int numberOfCars) {
        return new GameStage(maxOfRound, numberOfCars);
    }

    private void inputValueValid(int maxOfRound, int numberOfCars) {
        isPositiveNumber(maxOfRound);
        isPositiveNumber(numberOfCars);

    }

    private void isPositiveNumber(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("0또는 음수값은 올 수 없어요.");
        }
    }


}
