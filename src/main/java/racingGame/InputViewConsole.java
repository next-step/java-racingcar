package racingGame;

import java.util.Arrays;
import java.util.Objects;

public class InputViewConsole implements InputView {
    int runDistance;
    String[] inputCarsName;

    @Override
    public void setInputCarsName(String[] newCarsName) {
        this.inputCarsName = newCarsName;
    }

    @Override
    public String[] getInputCarsName() {
        return this.inputCarsName.length > 0
                ? this.inputCarsName
                : new String[0];
    }

    @Override
    public void setInputRunDistance(int runDistance) {
        this.runDistance = runDistance;
    }

    @Override
    public int getInputRunDistance() {
        return this.runDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputViewConsole that = (InputViewConsole) o;
        return runDistance == that.runDistance &&
                Arrays.equals(inputCarsName, that.inputCarsName);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(runDistance);
        result = 31 * result + Arrays.hashCode(inputCarsName);
        return result;
    }
}
