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
    }

    public void ready() {
        entry.enterCars();
    }

    public void race() {
        Entry entry = this.entry;
        for (int i = 0; i < round; i++) {
            entry = startRound(entry);
            resultView.view(entry);
        }
    }

    private Entry startRound(Entry entry) {
        for (Car car : entry.getCars()) {
            if (roulette.spin() >= 4) {
                car.move();
            }
        }

        return entry;
    }
}
