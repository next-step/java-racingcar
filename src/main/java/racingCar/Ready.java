package racingCar;

public class Ready {
    private static final String SPLIT_VALUE = ",";

    public String[] splitter(String carName) {
        return carName.split(SPLIT_VALUE);
    }

    public boolean checkNameLength(String carName) {
        return carName.length() <= 4;
    }


}
