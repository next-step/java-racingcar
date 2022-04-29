package racingCar;

import java.util.List;

public class RacingGame {
    public void startGame(){
        InputView inputView = new InputView();
        List<String> nameList = inputView.nameList();
        int numberOfGame = inputView.numberOfGame();

        Cars cars = new Cars(nameList);

        ResultView resultView = new ResultView();

        System.out.println("\n실행 결과");
        while(numberOfGame>0){
            resultView.resultOfCars(cars);
            numberOfGame--;
        }
        resultView.resultOfWinners(cars);
    }
}
