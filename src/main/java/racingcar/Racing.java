package racingcar;

public class Racing {
    //    private final List<Car> cars;
    private CarCollection carCollection;

    public void main() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        buildCarCollection(inputView.getCarNames(), inputView.getTrialCount());
        resultView.displayResults(carCollection);
        resultView.displayWinnerMessage(carCollection);
    }

    private void buildCarCollection(String carNames, int trialCount) {
        carCollection = new CarCollection();

        String[] names = carNames.split(",");

        for (String name : names) {
            Car car = new Car(name, trialCount);
            carCollection.addCar(car);
        }
    }

    public CarCollection getCarCollection() {
        return carCollection;
    }
}
