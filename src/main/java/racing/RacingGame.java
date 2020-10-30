package racing;

public class RacingGame {

    private int carCount;

    private int round;

    private Car[] cars;

    private final InputValue inputValue;

    public RacingGame() {
        this.inputValue = new InputValue();
    }

    public void set() {
        this.carCount = inputValue.setCarCount();
        this.round = inputValue.setRound();
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
