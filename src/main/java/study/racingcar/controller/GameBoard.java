package study.racingcar.controller;

import java.util.Random;
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

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RandomGenerator randomGenerator = new RandomGenerator(new Random());



    public void racingGameStart() {

        outputView.printRequestTextInitCar();
        Cars cars = inputView.initCar().stream()
            .map(Car::new)
            .collect(Collectors.collectingAndThen(Collectors.toList(), Cars::from));

        outputView.printRequestTextInitRound();
        Rounds rounds = IntStream.range(0, inputView.initRound())
            .mapToObj(i -> new Round(cars))
            .collect(Collectors.collectingAndThen(Collectors.toList(), Rounds::from));

        ScoreBoard scoreBoard = new ScoreBoard();

        rounds.roundList().forEach(round -> {
            ScoreEachRound race = round.race(scoreBoard, randomGenerator);
            scoreBoard.score(race);
        });

        ScoreBoardResult scoreBoardResult = new ScoreBoardResult();
        History history = scoreBoardResult.history(scoreBoard);
        ScoreBoardView.printResult(history);
        ScoreBoardView.printWinner(history.winners());
    }
}

