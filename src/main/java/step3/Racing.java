package step3;

import java.util.List;
import step3.domain.Car;
import step3.domain.Cars;
import step3.domain.RandomMoveStrategy;
import step3.domain.Rule;
import step3.view.InputView;
import step3.view.ResultView;
import step3.util.CarConstant;
import step3.util.RandomUtil;

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
