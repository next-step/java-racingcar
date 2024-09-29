package race;

public class Car {

    private int forwardResult = 1;
    private RandomNumber carForwardCheck;

    public Car(RandomNumber carForwardCheck) {
        this.carForwardCheck = carForwardCheck;
    }

    public void forward() {
        if (checkCarForward()) {
            forwardResult++;
        }
    }

    private boolean checkCarForward() {
        return carForwardCheck.isForward();
    }

    public int getForwardResult() {
        return forwardResult;
    }
}
