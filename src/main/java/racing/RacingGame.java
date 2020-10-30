package racing;

public class RacingGame {

    private Setting setting;

    private Car[] cars;

    private Roulette roulette;

    public RacingGame() {
        this.setting = new Setting();
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
    }
}
