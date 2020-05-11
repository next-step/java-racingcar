package racing;

public class Car {
    private int position = 0;
    private CarMovement carMovement;

    public Car(CarMovement carMovement) {
        if (carMovement == null) {
            throw new IllegalArgumentException();
        }
        this.carMovement = carMovement;
    }

    public void move() {
        boolean isRun = this.carMovement.run();
        if (isRun) {
            this.position++;
        }
    }

    public int currentPosition() {
        return this.position;
    }
}
