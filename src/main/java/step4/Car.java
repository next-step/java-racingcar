package step4;

public class Car {

    private String carName;
    private int location = 0;
    private boolean isMovable;

    public Car(String carName) {
        this.carName = carName;
    }

    void moveForward(boolean isMovable) {
        this.isMovable = isMovable;

        if (this.isMovable) {
            this.location++;
        }
    }

    public String getCarName(){
        return this.carName;
    }

    public int getLocation() {
        return this.location;
    }
}
