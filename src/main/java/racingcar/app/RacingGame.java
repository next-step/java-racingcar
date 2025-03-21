package racingcar.app;

import racingcar.domain.Car;
import racingcar.domain.MoveStrategy;
import racingcar.domain.Race;
import racingcar.domain.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class RacingGame {
    public static void play() {
        InputView inputView = new InputView(new Scanner(System.in));
        int carCount = inputView.getCarCount();
        int attempts = inputView.getAttempts();

        List<Car> cars = IntStream.range(0, carCount)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());

        Race race = new Race(cars, new RandomMoveStrategy());
        race.start(attempts);
    }
}

