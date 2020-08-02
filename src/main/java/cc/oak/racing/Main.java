package cc.oak.racing;

import cc.oak.racing.condition.CarForwardCondition;
import cc.oak.racing.condition.Condition;
import cc.oak.racing.condition.RangeCondition;
import cc.oak.racing.converter.Converter;
import cc.oak.racing.converter.CarRandomIntConverter;
import cc.oak.racing.printer.CarPrinter;
import cc.oak.racing.printer.StringPrinter;
import cc.oak.racing.view.InputView;
import cc.oak.racing.view.InputViewImpl;
import cc.oak.racing.view.ResultView;
import cc.oak.racing.view.ResultViewImpl;

public class Main {
    private static final int MIN = 0;
    private static final int MAX = 4;

    private final InputView inputView;
    private final ResultView resultView;
    private final RacingGame racingGame;

    public Main() {
        this.inputView = new InputViewImpl();

        StringPrinter<Car> carPrinter = new CarPrinter();
        this.resultView = new ResultViewImpl(carPrinter);

        Condition<Integer> condition = new RangeCondition(MIN, MAX);
        Converter<Car, Integer> converter = new CarRandomIntConverter();
        CarForwardCondition<Integer> carForwardCondition = new CarForwardCondition<>(condition, converter);
        this.racingGame = new RacingGame(carForwardCondition);
    }

    public void start() {
        int totalCarCount = inputView.readTotalNumberOfCars();
        int totalRoundCount = inputView.readTotalRoundCount();

        resultView.printResultHeader();

        RacingRound round = racingGame.createRound(totalCarCount, totalRoundCount);
        while(round.hasNextRound()) {
            round.nextRound();
            resultView.printCar(round);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
}
