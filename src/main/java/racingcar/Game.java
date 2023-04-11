package racingcar;

public class Game {

    private final WatingCars watingCars;
    private final Round round;

    public Game(int count, int number) {
        this.watingCars = new WatingCars(count);
        this.round = new Round(number);
    }

    public void play() {
        Billboard.notice();
        for (int i = 0; i < round.getNumber(); i++) {
            round();
        }
    }

    private void round() {
        for (Car car : this.watingCars.getCars()) {
            car.racing();
        }
        Billboard.result(this.watingCars);
    }

}
