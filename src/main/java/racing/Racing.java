package racing;

public class Racing {
    private final int tryTimes;
    private final Cars cars;

    public Racing(int movingCount, Cars cars) {
        this.tryTimes = movingCount;
        this.cars = cars;
    }

    public void start() {
        ResultView.printResultMessage();
        for (int i = 0; i < tryTimes; i++) {
            cars.move();
            ResultView.printRacingStatus(cars);
        }
    }

    public void end() {
        ResultView.printEndGame(ChooseTheWinner());
    }

    public RaceWinner ChooseTheWinner() {
        return new RaceWinner(cars);
    }
}
