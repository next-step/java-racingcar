package racingcar;

import java.util.Scanner;

import racingcar.domain.moving.RandomMovingStrategy;
import racingcar.view.DistanceSymbol;
import racingcar.view.GameInputView;
import racingcar.view.GameOutputView;

public class Main {
    public static void main(String[] args) {
        new CarRacingGame(
                new GameInputView(new Scanner(System.in)), 
                new GameOutputView(DistanceSymbol.of(args)),
                new RandomMovingStrategy()
        ).start();
    }
}
