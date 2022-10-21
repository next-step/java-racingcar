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
        moveLocation();
        maxLocation.checkMax(location);
        return getResultStringBuilder();
    }

    private void moveLocation() {
        this.location = location.move(generateRandomNumber());
    }

    public void findName(List<String> carNameList, MaxLocation maxLocation) {
        if (isMaxLocation(maxLocation)) {
            carNameList.add(carName);
        }
    }

    private boolean isMaxLocation(MaxLocation maxLocation) {
        return maxLocation.isMaxLocation(location);
    }

    }

    private boolean isOverCarNameMaxSize(String carName) {
        return carName.length() > CAR_NAME_MAXSIZE;
    }
}
