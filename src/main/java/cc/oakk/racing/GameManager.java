package cc.oakk.racing;

import cc.oakk.racing.condition.CarForwardCondition;
import cc.oakk.racing.condition.Condition;
import cc.oakk.racing.condition.RangeCondition;
import cc.oakk.racing.converter.Converter;
import cc.oakk.racing.converter.CarRandomIntConverter;
import cc.oakk.racing.printer.CarPrinter;
import cc.oakk.racing.printer.StringPrinter;
import cc.oakk.racing.view.InputView;
import cc.oakk.racing.view.InputViewImpl;
import cc.oakk.racing.view.ResultView;
import cc.oakk.racing.view.ResultViewImpl;

public class GameManager {
    private static final int MIN = 0;
    private static final int MAX = 4;

    private final InputView inputView;
    private final ResultView resultView;
    private final RacingGame racingGame;

    public GameManager() {
        this.inputView = new InputViewImpl();

        StringPrinter<Car> carPrinter = new CarPrinter();
        this.resultView = new ResultViewImpl(carPrinter);

        Condition<Integer> condition = new RangeCondition(MIN, MAX);
        Converter<Car, Integer> converter = new CarRandomIntConverter();
        CarForwardCondition<Integer> carForwardCondition = new CarForwardCondition<>(condition, converter);
        this.racingGame = new RacingGame(carForwardCondition);
    }

    public void start() {
        int totalCarCount = readTotalNumberOfCarsUntilValid();
        int totalRoundCount = readTotalRoundCountUntilValid();

        resultView.printResultHeader();
        RacingRound round = racingGame.createRound(totalCarCount, totalRoundCount);
        while(round.hasNextRound()) {
            round.nextRound();
            resultView.printCar(round);
        }
    }

    private int readTotalNumberOfCarsUntilValid() {
        int totalCarCount;
        do {
            totalCarCount = inputView.readTotalNumberOfCars();
        } while (totalCarCount < 0);
        return totalCarCount;
    }

    private int readTotalRoundCountUntilValid() {
        int totalRoundCount;
        do {
            totalRoundCount = inputView.readTotalRoundCount();
        } while (totalRoundCount < 0);
        return totalRoundCount;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
}
