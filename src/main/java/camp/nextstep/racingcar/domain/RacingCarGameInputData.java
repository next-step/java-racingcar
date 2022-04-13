package camp.nextstep.racingcar.domain;

public class RacingCarGameInputData {

    private final int countOfCar;
    private final int rounds;

    public RacingCarGameInputData(int countOfCar, int rounds) {
        this.countOfCar = countOfCar;
        this.rounds = rounds;
    }

    public int getCountOfCar() {
        return countOfCar;
    }

    public int getRounds() {
        return rounds;
    }
}
