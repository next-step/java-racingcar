package racingcar;

public class GameSet {

    private int cars;
    private int givenRound;

    public GameSet(int cars, int givenRound) {
        this.cars = cars;
        this.givenRound = givenRound;
    }

    public int getCars() {
        return cars;
    }

    public int getGivenRound() {
        return givenRound;
    }
}
