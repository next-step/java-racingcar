package racingcar;

public class Main {
    public static void main(String[] args) {
        View view = new View();

        CarCount carCount = new CarCount(view.inputCarCount());
        TrialCount trialCount = new TrialCount(view.inputTrialCount());

        Cars cars = new Cars(carCount.create());
        trialCount.start(cars);

        view.printResult(cars);
    }
}
