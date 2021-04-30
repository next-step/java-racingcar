package racegame;

public class RacingCar {
    private String carName;
    private int goStep;

    public RacingCar(String carName, int goStep) {
        this.carName = carName;
        this.goStep = goStep;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getGoStep() {
        return goStep;
    }

    public void setGoStep(int goStep) {
        this.goStep = goStep;
    }
}
