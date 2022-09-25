package racing.model;

public class Car {
    private int position;
    private final int MOVE_THRESHOLD = 4;

    public Car(int initPosition) {
        this.position = initPosition;
    }

    public Car() {
        this.position = 1;
    }

    public boolean canMove(int randomNum) {
        return randomNum >= MOVE_THRESHOLD;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Car car = (Car) obj;
        return car.position == this.position;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public void move() {
        this.position += 1;
    }

    public String printPosition() {
        String currentLocation = "";
        for (int i = 0; i < position; i++) {
            currentLocation += "-";
        }
        return currentLocation;
    }
}
