package step3;

import java.util.Scanner;

import static step3.Game.cars;

public class inputScanner {


    public static void main(String args[]){
        InputView inputView = new InputView();
        Game game = new Game();

        int carCount = Integer.parseInt(new Scanner(System.in).nextLine());
        int roundCount = Integer.parseInt(new Scanner(System.in).nextLine());

        inputView.viewCountCarInputMessage();
        cars.createCars(carCount);
        inputView.viewCountCar();


        inputView.viewCountRoundInputMessage();
        game.setRoundCount(roundCount);
        inputView.viewCountRound();

        ResultView.viewResultMessage();

        for (int i = 0; i < roundCount; i++) {
            game.playRound();
        }
    }
}
