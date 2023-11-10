package study.racingcar;

import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

        LinkedList<Map<Car, String>> result = ScoreBoardResult.create().result(scoreBoard);
        ScoreBoardView.printResult(result);
        ScoreBoardView.printWinner(result);
    }
}
