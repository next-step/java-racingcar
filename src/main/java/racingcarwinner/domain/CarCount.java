package racingcarwinner.domain;

public class CarCount {
    private final int count;

    public CarCount(String[] carNamesArray) {
        this.count = carNamesArray.length;
    }

}
