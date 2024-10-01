package race;

public class Car {

    private String carName;
    private int forwardResult = 1;
    private ForwardCheck carForwardCheck;

    public Car(String carName, ForwardCheck carForwardCheck) {
        this.carName = carName;
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

    public String getCarName() {
        return carName;
    }
}
