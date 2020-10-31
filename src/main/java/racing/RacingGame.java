package racing;

public class RacingGame {

    private final InputView inputView;

    private final Roulette roulette;

    private Entry entry;

    private int round;

    public RacingGame() {
        this.inputView = new InputView();
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
        for (int i = 0; i < round; i++) {
            startRound();
            resultView.view();
        }
    }

    private void startRound() {
        for (Car car : entry.getCars()) {
            if (roulette.spin() >= 4) {
                car.move();
            }
        }
    }
}
