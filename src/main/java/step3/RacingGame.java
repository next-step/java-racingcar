package step3;

import java.util.List;
import java.util.Scanner;

public class RacingGame {

    public static void main(String[] args) {

        InputView inputView = new InputView(new Scanner(System.in));
        inputView.getUserInput();
        Cars cars = new Cars(inputView.getCarCount());

        OutputView outputView = new OutputView();
        DiceWithRandom dice = new DiceWithRandom();
        for (int time = 0; time < inputView.getInputTime(); time++) {

            List<Car> carList = cars.playGame(dice);
            outputView.resultPrint(carList);
            System.out.println("============" + (time + 1) + "실행 끝==================");
        }
    }


}
