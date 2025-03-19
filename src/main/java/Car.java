public class Car {

    static final int MOVE_THRESHOLD = 4;
    static final int CAR_NAME_THRESHOLD = 5;

    private int distance;
    private String carName;

    public Car() {
        this.distance = 0;
    }

    public Car(String carName) {
        if(carName == null || carName.isBlank() || carName.length() > CAR_NAME_THRESHOLD){
            throw new IllegalArgumentException(Messages.ERROR_CAR_NAME_LENGTH);
        }
        this.distance = 0;
        this.carName = carName;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getCarName() {
        return this.carName;
    }

    public void move(int randomNumber) {
        if (isMovable(randomNumber)) distance++;
    }

    public boolean isMovable(int randomNumber) {
        return randomNumber >= MOVE_THRESHOLD;
    }
}
