package cc.oakk.racing.controller;

import cc.oakk.racing.model.Car;
import cc.oakk.racing.model.RacingGame;
import cc.oakk.racing.model.RacingRound;
import cc.oakk.racing.model.Ranking;
import cc.oakk.racing.model.predicate.CarForwardCondition;
import cc.oakk.racing.model.predicate.RangePredicate;
import cc.oakk.racing.model.converter.Converter;
import cc.oakk.racing.model.converter.CarRandomIntConverter;
import cc.oakk.racing.view.printer.CarPrinter;
import cc.oakk.racing.view.printer.RankingPrinter;
import cc.oakk.racing.view.printer.StringPrinter;
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
