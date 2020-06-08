package racing;

import java.util.List;
import java.util.Scanner;

public class RacingGame {

    public static void main(String[] args) {

        InputView inputView = new InputView(new Scanner(System.in));
        inputView.getUserInput();
        Cars cars = new Cars(inputView.getnameList());

        OutputView outputView = new OutputView();
        Dice dice = new DiceWithRandom();

        for (int time = 0; time < inputView.getInputTime(); time++) {

            cars.playGame(dice);
            List<Car> carList = cars.getCarList();
            outputView.resultPrint(carList);
        }

        List<String> winner = cars.getWinner();
        outputView.printWinner(winner);
    }


}
