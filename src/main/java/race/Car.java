package race;

public class Car {

    private int forwardResult = 1;
    private ForwardCheck carForwardCheck;

    public Car(ForwardCheck carForwardCheck) {
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
