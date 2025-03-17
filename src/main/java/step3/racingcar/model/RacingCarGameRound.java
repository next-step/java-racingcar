package step3.racingcar.model;

public class RacingCarGameRound {

    private final int no;
    private final RacingCar[] cars;

    public RacingCarGameRound(int no, RacingCar[] cars) {
        this.no = no;
        this.cars = cars;
    }

    public int no() {
        return this.no;
    }

    public RacingCar[] cars() {
        return this.cars;
    }

}
