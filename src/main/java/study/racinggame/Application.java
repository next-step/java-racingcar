package study.racinggame;

import study.racinggame.domain.*;
import study.racinggame.domain.strategy.RandomMoveStrategy;
import study.racinggame.util.NameUtil;
import study.racinggame.view.InputView;
import study.racinggame.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        final List<String> carNames = NameUtil.convertToList(InputView.carNames());
        final int repeatCount = InputView.repeatCount();
        final Cars cars = new Cars(carNames);
        final RaceGame raceGame = new RaceGame(cars, repeatCount, new RandomMoveStrategy());

        while (!raceGame.isEndGame()) {
            raceGame.race();
            ResultView.printOutPositions(cars);
        }

        final List<String> winnerNames = raceGame.winners()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        ResultView.printOutWinner(winnerNames);
    }
}
