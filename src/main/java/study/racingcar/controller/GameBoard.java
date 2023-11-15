package study.racingcar.controller;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import study.racingcar.domain.car.Car;
import study.racingcar.domain.car.Cars;
import study.racingcar.domain.history.History;
import study.racingcar.domain.round.Round;
import study.racingcar.domain.round.Rounds;
import study.racingcar.domain.score.ScoreBoard;
import study.racingcar.domain.score.ScoreBoardResult;
import study.racingcar.domain.score.ScoreEachRound;
import study.racingcar.util.RandomGenerator;
import study.racingcar.view.InputView;
import study.racingcar.view.OutputView;
import study.racingcar.view.ScoreBoardView;

public class GameBoard {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomGenerator randomGenerator = new RandomGenerator(new Random());

    public GameBoard(Scanner scanner, PrintStream out) {
        this.inputView = new InputView(scanner);
        this.outputView = new OutputView(out);
    }

    public void racingGameStart() {
        Cars cars = initializeCars();
        Rounds rounds = initializeRounds(cars);
        ScoreBoard scoreBoard = roundStart(rounds);
        printGameResult(scoreBoard);
    }

    private static void printGameResult(ScoreBoard scoreBoard) {
        ScoreBoardResult scoreBoardResult = new ScoreBoardResult();
        History history = scoreBoardResult.history(scoreBoard);
        ScoreBoardView.printResult(history);
        ScoreBoardView.printWinner(history.winners());
    }

    private ScoreBoard roundStart(Rounds rounds) {
        ScoreBoard scoreBoard = new ScoreBoard();
        rounds.roundList().forEach(round -> {
            ScoreEachRound race = round.race(scoreBoard, randomGenerator);
            scoreBoard.score(race);
        });
        return scoreBoard;
    }

    private Rounds initializeRounds(Cars cars) {
        outputView.printRequestTextInitRound();
        return IntStream.range(0, inputView.initRound())
            .mapToObj(i -> new Round(cars))
            .collect(Collectors.collectingAndThen(Collectors.toList(), Rounds::from));
    }

    private Cars initializeCars() {
        outputView.printRequestTextInitCar();
        return inputView.initCar().stream()
            .map(Car::new)
            .collect(Collectors.collectingAndThen(Collectors.toList(), Cars::from));
    }
}

