package racingcar.domain;

public class RacingCarGame {

    private Cars cars;
    private int times;

    public RacingCarGame(int carNum, int times) {
        this.cars = new Cars(carNum);
        this.times = times;
    }

    public void start() {
        for (int i = 0; i < times; i++) {
            cars.play();
            cars.printPosition();
        }
    }
}
