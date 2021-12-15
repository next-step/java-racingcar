package step3;

import java.util.Scanner;


public class InputScanner {


    public static void main(String[] args){
        InputView inputView = new InputView();
        //TODO : 사용자가 입력한값을 리턴하도록해서 static 변수 직접 접근 안하기
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
