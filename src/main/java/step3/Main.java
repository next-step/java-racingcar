package step3;

import java.util.Scanner;
import step3.models.CarFactory;
import step3.models.Game;
import step3.ui.InputView;
import step3.ui.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));

        String carsString = inputView.inputString();
        int tryNumber = inputView.inputTryNumber();

        CarFactory carFactory = new CarFactory(carsString);

        Game game = new Game(carFactory.createCarList(), tryNumber);

        OutputView outputView = new OutputView(game.play());

        outputView.printResult();
    }
}
