package step3;

import java.util.List;

public class Racing {

    private final InputView inputView;
    private final ResultView resultView;
    private final Cars cars;
    private final Rule rule;

    public Racing() {
        this.rule = new Rule(CarConstant.INIT_POSITION,
            new RandomMoveStrategy(RandomUtil.BOUND10, CarConstant.MOVE_CRITERIA),
            CarConstant.LIMIT_MAX_NAME_LENGTH);
        this.cars = new Cars();
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void run() {
        joinRacing();
        startRacing();
        finish();
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
            cars.move(rule.getMoveStrategy());
            resultView.printCars(cars);
        }
    }

    private String[] inputCarNames() {
        String inputName = inputView.enterCarName();
        String[] names = inputView.splitInput(inputName);
        inputView.validateCarName(names, rule.getNameLengthLimit());
        return names;
    }

    private void finish() {
        List<Car> winners = cars.getWinners();
        resultView.printWinners(winners);
    }
}
