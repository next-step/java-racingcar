package step3.racingcar;

public class RacingCarGameRound {

    private final int no;
    private final RacingCar[] cars;

    public RacingCarGameRound(int no, RacingCar[] cars) {
        this.no = no;
        this.cars = cars;
    }

    public void start() {
        for (RacingCar car : cars) {
            car.run();
        }
    }

    public void showResult() {
        System.out.println("Round #" + this.no);
        for (RacingCar car : cars) {
            car.show();
        }
        System.out.println();
    }
}
