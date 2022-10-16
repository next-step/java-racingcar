package step4;

import java.util.List;

import static step4.Util.generateRandomNumber;

public class Car {
    private static final int CAR_NAME_MAXSIZE = 5;
    private final String carName;
    private Location location;

    public Car(String carName) {
        if (isOverCarNameMaxSize(carName)) {
            throw new IllegalArgumentException("자동차이름이 너무 깁니다.");
        }
        this.carName = carName;
        this.location = new Location();
    }

    public StringBuilder getResult(MaxLocation maxLocation) {
        findMaxLocation(maxLocation);
        return getResultStringBuilder();
    }

    public void findName(List<String> carNameList, MaxLocation maxLocation) {
        if (isEqualToMaxLocation(maxLocation)) {
            carNameList.add(carName);
        }
    }

    private boolean isEqualToMaxLocation(MaxLocation maxLocation) {
        return maxLocation.isEqualToMaxLocation(location.getPosition());
    }

    private StringBuilder getResultStringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append(carName).append(" : ").append("-".repeat(location.getPosition())).append("\n");
        return sb;
    }

    private void findMaxLocation(MaxLocation maxLocation) {
        location = moveLocation();
        maxLocation.setMaxLocation(location.getPosition());
    }

    private Location moveLocation() {
        return location.move(generateRandomNumber());
    }

    private boolean isOverCarNameMaxSize(String carName) {
        return carName.length() > CAR_NAME_MAXSIZE;
    }
}
