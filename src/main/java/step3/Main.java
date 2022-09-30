package step3;

import java.util.Scanner;
import step3.domains.CarFactory;
import step3.domains.Game;
import step3.ui.InputView;
import step3.ui.ResultView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));

        String carsString = inputView.inputString();
        int tryNumber = inputView.inputTryNumber();

        CarFactory carFactory = new CarFactory(carsString);

        Game game = new Game(carFactory.createCarList(), tryNumber);

        ResultView outputView = new ResultView(game.play());

        outputView.printResult();
        outputView.printWinnerList();
    }
}
