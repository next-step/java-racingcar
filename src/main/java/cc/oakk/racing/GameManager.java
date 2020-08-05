package cc.oakk.racing;

import cc.oakk.racing.predicate.CarForwardCondition;
import cc.oakk.racing.predicate.RangePredicate;
import cc.oakk.racing.converter.Converter;
import cc.oakk.racing.converter.CarRandomIntConverter;
import cc.oakk.racing.printer.CarPrinter;
import cc.oakk.racing.printer.RankingPrinter;
import cc.oakk.racing.printer.StringPrinter;
import cc.oakk.racing.view.InputView;
import cc.oakk.racing.view.InputViewImpl;
import cc.oakk.racing.view.ResultView;
import cc.oakk.racing.view.ResultViewImpl;

import java.util.List;
import java.util.function.Predicate;

public class GameManager {
    private static final int MIN = 0;
    private static final int MAX = 4;

    private final InputView inputView;
    private final ResultView resultView;
    private final RacingGame racingGame;

    public GameManager() {
        this.inputView = new InputViewImpl();

        StringPrinter<Car> carPrinter = new CarPrinter();
        StringPrinter<Ranking> rankingPrinter = new RankingPrinter();
        this.resultView = new ResultViewImpl(carPrinter, rankingPrinter);

        Predicate<Integer> predicate = new RangePredicate(MIN, MAX);
        Converter<Car, Integer> converter = new CarRandomIntConverter();
        CarForwardCondition<Integer> carForwardCondition = new CarForwardCondition<>(predicate, converter);
        this.racingGame = new RacingGame(carForwardCondition);
    }

    public void start() {
        List<String> carNames = inputView.readNameOfCars();
        int totalRoundCount = readTotalRoundCountUntilValid();

        resultView.printResultHeader();
        RacingRound round = racingGame.createRound(carNames, totalRoundCount);
        while(round.hasNextRound()) {
            round.nextRound();
            resultView.printCar(round);
        }
        resultView.printRanking(round.getRanking());
    }

    private int readTotalNumberOfCarsUntilValid() {
        int totalCarCount;
        do {
            totalCarCount = inputView.readTotalNumberOfCars();
        } while (totalCarCount <= 0);
        return totalCarCount;
    }

    private int readTotalRoundCountUntilValid() {
        int totalRoundCount;
        do {
            totalRoundCount = inputView.readTotalRoundCount();
        } while (totalRoundCount <= 0);
        return totalRoundCount;
    }
}
