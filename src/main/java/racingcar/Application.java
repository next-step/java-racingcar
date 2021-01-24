package racingcar;

import java.util.Scanner;
import racingcar.controller.GameController;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView();
        inputView.requestInput();

        GameController gameController = new GameController();
        gameController.activate(scanner);

        ResultView resultView = new ResultView();
        resultView.printResult();
    }
}
