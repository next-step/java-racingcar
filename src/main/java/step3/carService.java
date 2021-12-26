package step3;

import java.util.Scanner;


public class carService {
    public static void main(String[] args){
        InputView inputView = new InputView();
        Game game = new Game(3);
        //TODO : 사용자가 입력한값을 리턴하도록해서 static 변수 직접 접근 안하기
        inputView.inputScanUn();
        Cars cars = new Cars();
        inputView.viewCountCar();
        inputView.viewCountRound();
        ResultView.viewResultMessage();
        game.execround();
    }
}
