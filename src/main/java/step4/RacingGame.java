package step4;


public class RacingGame {
    private final Cars cars;
    private final int rounds;
    private final OutputView outputView;

    public RacingGame(Cars cars, int rounds, OutputView outputView) {
        this.cars = cars;
        this.rounds = rounds;
        this.outputView = outputView;
    }

    public void startGame() {
        for (int round = 0; round < rounds; round++) {
            playRound();
        }
        outputView.printWinners(cars.getWinners());
    }

    private void playRound() {
        cars.moveAll();
        outputView.printRaceProgress(cars.currentStatus());
    }
}
