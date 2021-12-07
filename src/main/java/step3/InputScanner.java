package step3;

import java.util.Scanner;

import static step3.Game.cars;

public class InputScanner {


    public static void main(String[] args){
        InputView inputView = new InputView();


        inputView.inputScanUn();
        Game game = new Game(InputView.roundCount,InputView.carCount);
        inputView.viewCountCarInputMessage();
        cars.createCars();


        inputView.viewCountCar();
        inputView.viewCountRoundInputMessage();
        inputView.viewCountRound();

        ResultView.viewResultMessage();


        game.execround(InputView.roundCount);
    }
}
