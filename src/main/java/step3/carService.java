package step3;

import java.util.Scanner;


class carService {
    public static void main(String[] args){
        InputView inputView = new InputView();
        //TODO : 사용자가 입력한값을 리턴하도록해서 static 변수 직접 접근 안하기
        inputView.inputScanUn();
        Game game = new Game(3);
        inputView.viewCountCarInputMessage();
        Cars cars = new Cars(5);
        inputView.viewCountCar(cars.getSize());
        inputView.viewCountRoundInputMessage();
        inputView.viewCountRound(game.getRoundCount());

        ResultView.viewResultMessage();


        game.execround(game.roundCount);
    }
}
