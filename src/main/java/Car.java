public class Car {
    private int distance;
    private String carName;

    public Car() {
        this.distance = 0;
    }

    public Car(String carName) {
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
        return randomNumber >= Constants.MOVE_THRESHOLD;
    }
}
