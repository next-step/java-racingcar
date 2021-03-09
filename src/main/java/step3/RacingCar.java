package step3;

public class RacingCar {

    private int car;
    private int trial;

    public RacingCar() {}

    public void setCar(int car) {
        this.car = car;
    }

    public void setTrial(int trial) {
        this.trial = trial;
    }

    void start() {
        ResultView resultView = new ResultView();
        resultView.printResult(car, trial);
    }

}
