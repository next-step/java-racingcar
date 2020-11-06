package study.racing;

public class RacingInput {

    private final int countOfCar;
    private final int countOfRound;

    public RacingInput(int countOfCar, int countOfRound) {
        this.countOfCar = countOfCar;
        this.countOfRound = countOfRound;
    }

    public int getCountOfCar() {
        return countOfCar;
    }

    public int getCountOfRound() {
        return countOfRound;
    }
}
