package racingcar.model;

public class RacingGameRequest {
    private final int countOfCar;
    private final int countOfTry;

    public RacingGameRequest(int countOfCar, int countOfTry) {
        this.countOfCar = countOfCar;
        this.countOfTry = countOfTry;
    }

    public int getCountOfCar() {
        return countOfCar;
    }

    public int getCountOfTry() {
        return countOfTry;
    }
}
