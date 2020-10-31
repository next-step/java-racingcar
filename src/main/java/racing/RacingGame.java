package racing;

public class RacingGame {

    private final InputView inputView;

    private final ResultView resultView;

    private final Roulette roulette;

    private Entry entry;

    private int round;

    public RacingGame() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.roulette = new Roulette();
    }

    public void set() {
        int carCount = inputView.readCarCount();
        this.entry = new Entry(carCount);

        this.round = inputView.readRound();

        inputView.closeScanner();
    }

    public void ready() {
        entry.enterCars();
    }

    public void race() {
        Entry entry = this.entry;
        resultView.viewMessage();
        for (int i = 0; i < round; i++) {
            startRound(entry);
            resultView.viewRoundResult(entry);
        }
    }

    private void startRound(Entry entry) {
        for (Car car : entry.getCars()) {
            if (roulette.spin() >= 4) {
                car.move();
            }
        }
    }
}
