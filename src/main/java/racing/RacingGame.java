package racing;

public class RacingGame {

    private int carCount;

    private int round;

    private final InputValue inputValue;

    public RacingGame() {
        this.inputValue = new InputValue();
    }

    public void setGame() {
        this.carCount = inputValue.setCarCount();
        this.round = inputValue.setRound();
    }

    public void startGame() {
    }
}
