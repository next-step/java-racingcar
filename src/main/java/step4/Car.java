package step4;

public class Car {

    private int location = 0;
    private boolean isMovable;

    void moveForward(boolean isMovable) {
        this.isMovable = isMovable;

        if (this.isMovable) {
            this.location++;
        }
    }

    public int getLocation() {
        return this.location;
    }
}
