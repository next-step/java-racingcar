package racingcar;

public class InputValue {
    private final String names;
    private final int tryCount;

    public InputValue(String names, int tryCount) {
        this.names = names;
        this.tryCount = tryCount;
    }

    public String getNameOfCars() {
        return names;
    }

    public int getTryCount() {
        return tryCount;
    }


}