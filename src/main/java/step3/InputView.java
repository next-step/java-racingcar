package step3;

import java.util.Scanner;

public class InputView {
    private int carsCount;
    private int roundsCount;
    private String[] carsName;
    private Scanner scanner;

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
