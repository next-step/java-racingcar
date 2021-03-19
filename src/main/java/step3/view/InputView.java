package step3.view;

public class InputView {
    private int roundsCount;
    private String[] carsName;

    public InputView(String[] carsName, int roundsCount) {
        this.carsName = carsName;
        this.roundsCount = roundsCount;
    }

    public int getRoundsCount() {
        return this.roundsCount;
    }

    public String[] getCarsName() {
        return this.carsName;
    }
}
