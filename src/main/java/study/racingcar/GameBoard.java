package study.racingcar;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameBoard {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void racingGameStart(){

        outputView.printRequestTextInitCar();
        Cars cars = IntStream.range(0, inputView.initRound())
                .mapToObj(i -> new Car(new RandomGenerator(new Random())))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Cars::from));

        outputView.printRequestTextInitRound();
        Rounds rounds = IntStream.range(0, inputView.initRound())
                .mapToObj(i -> new Round(cars))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Rounds::from));

        ScoreBoard scoreBoard = new ScoreBoard();

        rounds.roundList().forEach(round -> {
            round.race(scoreBoard);
        });

        outputView.printListMapValues(scoreBoard.scores());
        outputView.printEnter();
    }
}
