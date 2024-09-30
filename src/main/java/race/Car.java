package race;

public class Car {

    private final static String EXPRESS_STRING = "-";
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

    public String getCarPosition() {
        return EXPRESS_STRING.repeat(forwardResult);
    }
}
