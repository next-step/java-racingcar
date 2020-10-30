package racing;

public class RacingGame {

    private final Setting setting;

    private final Roulette roulette;

    private Car[] cars;

    public RacingGame() {
        this.setting = new Setting();
        this.roulette = new Roulette();
    }

    public void set() {
        setting.set();
    }

    public void create() {
        cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car();
        }
    }

    public void start() {
        for (int i = 0; i < round; i++) {
            for (int i = 0; i < carCount; i++) {
                if (roulette.spin() >= 4) {
                    cars[i].move();
                }
            }

            resultView.view();
        }
    }
}
