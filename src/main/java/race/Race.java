package race;

public class Race {
    private final Cars cars;
    private final Round round;

    public Race(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public void run() {
        ResultView resultView = new ResultView();

        for (int i = 0; i < round.getValue(); i++) {
            cars.move();
            resultView.printCurrentRoundProgress(cars);
        }

        resultView.printWinners(cars.getWinners());
    }

}
