package racinggame;

import racinggame.domain.Cars;
import racinggame.domain.Referee;
import racinggame.domain.Split;
import racinggame.factory.FactoryCar;
import racinggame.strategy.RandomMove;
import racinggame.ui.InputView;

import java.util.Scanner;

public class RacingGame {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        String carName = inputView.carName();
        int racingCount = inputView.racingCount();

        Cars cars = new Cars(new FactoryCar().generateCar(new Split().toCarNames(carName), new RandomMove()));
        Referee referee = new Referee();
        referee.startRacing(racingCount, cars);
        referee.judgeWinners(cars);
    }

}
