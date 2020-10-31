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
        this.entry.setCarCount(carCount);

        this.round = inputView.readRound();
    }

    public void create() {
        cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car();
        }
    }

    public void start() {
        for (int i = 0; i < round; i++) {
            startRound();
            resultView.view();
        }
    }

    private void startRound() {
        for (int i = 0; i < carCount; i++) {
            if (roulette.spin() >= 4) {
                cars[i].move();
            }
        }
    }
}
