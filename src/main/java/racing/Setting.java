package racing;

public class Setting {

    private int carCount;

    private int round;

    private final InputValue inputValue;

    public Setting() {
        this.inputValue = new InputValue();
    }

    public void set() {
        this.carCount = inputValue.setCarCount();
        this.round = inputValue.setRound();
    }

    public int getCarCount() {
        return carCount;
    }

    public int getRound() {
        return round;
    }
}
