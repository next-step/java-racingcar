package step3;

import java.util.List;

public class Racing {

    private final InputView inputView;
    private final ResultView resultView;
    private final Cars cars;
    private final Rule rule;

    public Racing() {
        this.rule = new Rule(CarConstant.INIT_POSITION);
        this.cars = new Cars();
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void run() {
        joinRacing();
        startRacing();
        finish();
    }

    private Limit initLimit() {
        Limit carLimit = new CarLimit();
        carLimit.setLimitStrategy(new Limit4Strategy());
        return carLimit;
    }

    private void joinRacing() {
        String[] names = inputCarNames();
        cars.addCar(names, rule.getInitPosition());
        rule.setRoundCount(names.length);

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

    private String[] inputCarNames() {
        String inputName = inputView.enterCarName();
        String[] names = inputView.splitInput(inputName);
        inputView.validateCarName(names);
        return names;
    }

    private void finish() {
        List<Car> winners = cars.getWinners();
        resultView.printWinners(winners);
    }
}
