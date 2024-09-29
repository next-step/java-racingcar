package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        ResultView resultView = new ResultView(inputView.carNumber(), inputView.movement());
        resultView.print();
    }
}
