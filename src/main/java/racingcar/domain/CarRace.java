package racingcar.domain;

import racingcar.ui.InputView;
import racingcar.ui.ResultView;


public class CarRace {

    private final InputView inputView;
    private final ResultView resultView;

    public CarRace(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void race() {
        String nameString = inputView.readCarNameString();
        int tryCount = inputView.readHowManyTrys();

        String[] names = NameSeparator.separate(nameString);
        Cars cars = createCars(names);

        while (tryCount-- > 0) {
            cars.move(new RandomCarMoveStrategy());
            resultView.appendSnapshot(cars);
        }

        resultView.printCarRaceResult();
        Winners winners = new Winners();
        resultView.printWinnerNames(winners.who(cars));
    }

    private Cars createCars(String[] names) {
        return new Cars(names);
    }

}
