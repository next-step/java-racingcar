package racingcar;

import java.util.Scanner;

import racingcar.domain.Watcher;
import racingcar.view.ConsoleDisplayer;
import racingcar.view.GameInputView;
import racingcar.view.GameOutputView;

public class Main {
    public static void main(String[] args) {
        new CarRacingGame(new GameInputView(new Scanner(System.in)),
                          new GameOutputView(
                                  new Watcher(new ConsoleDisplayer("-"))
                          )
        ).start();
    }
}
