package step3;

public class Racing {

    private final InputView inputView;
    private final ResultView resultView;
    private final Cars cars;
    private final Rule rule;

    public Racing() {
        this.rule = new Rule(0, 0, initLimit());
        this.cars = new Cars();
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void run() {
        joinRacing();
        startRacing();
    }

    private Limit initLimit() {
        Limit carLimit = new CarLimit();
        carLimit.setLimitStrategy(new Limit4Strategy());
        return carLimit;
    }

    private void joinRacing() {
        int totalCarCount = inputView.enterCarCount();
        rule.setCarCount(totalCarCount);
        for (int carCount = 0; carCount < rule.getCarCount(); ++carCount) {
            cars.addCar(new Car(CarConstant.INIT_POSITION));
        }

        int totalRoundCount = inputView.enterRoundCount();
        rule.setRoundCount(totalRoundCount);
    }

    private void startRacing() {
        resultView.printResult();
        for (int round = 0; round < rule.getRoundCount(); ++round) {
            cars.move(rule.getLimit());
            resultView.printCars(cars);
        }
    }
}
