package racingcar;

import racingcar.domain.*;
import racingcar.view.Output;

import java.util.Scanner;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        Input input = new Input(
            new Scanner(System.in)
        );
        Output output = new Output();

        Cars cars = CarsFactory.createCars(
            input.getCarNames(), new MoveChecker()
        );
        int tryCount = input.getTryCount();

        Game game = new Game(cars, tryCount);

        output.printRoundStart();
        while (game.hasNextRound()) {
            ResultRound resultRound = game.nextRound();
            output.printRound(resultRound);
        }
        ResultWinners resultWinners = game.computeWinner();
        output.printWinners(resultWinners);
    }
}
