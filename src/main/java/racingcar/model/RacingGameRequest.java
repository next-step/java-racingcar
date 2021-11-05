package racingcar.model;

public class RacingGameRequest {
    private int countOfCar;
    private int countOfTry;

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
