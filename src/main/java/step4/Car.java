package step4;

public class Car {
    private static final int CAR_NAME_MAXSIZE = 5;
    private final String carName;
    private Location location;
    private final RandomNumber randomNumber;

    public Car(String carName) {
        this(carName, new Location(1));
    }

    public Car(String carName, Location location) {
        if (isOverCarNameMaxSize(carName)) {
            throw new IllegalArgumentException("자동차이름이 너무 깁니다.");
        }
        this.carName = carName;
        this.location = location;
        this.randomNumber = new RandomNumber();
    }

    public int findMaxLocation(int location) {
        return Math.max(location, getLocation());
    }

    public void moveLocation(int randomNum) {
        if (randomNumber.movable(randomNum)) {
            this.location = location.increaseLocation();
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getLocation() {
        return location.getPosition();
    }

    boolean isMaxLocation(int maxPosition) {
        return getLocation() == maxPosition;
    }

    private boolean isOverCarNameMaxSize(String carName) {
        return carName.length() > CAR_NAME_MAXSIZE;
    }
}
