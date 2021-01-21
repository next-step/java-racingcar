package racingcar.utils;

public class NameCheckerImpl implements NameChecker {

    @Override
    public String[] splitName(String inputLine) {
        return inputLine.split(",");
    }

    @Override
    public boolean checkAvailableCarName(String carName) {
        if(isEmptyName(carName)){
            throw new IllegalArgumentException("Car's name must be at least 1 letter.");
        }
        if (isTooLongCarNameLength(carName)) {
            throw new IllegalArgumentException("Car's name must be 5 characters or less.");
        }
        return true;
    }

    private boolean isTooLongCarNameLength(String carName) {
        return carName.length() > 5;
    }

    private boolean isEmptyName(String carName){
        return carName.isEmpty();
    }
}
