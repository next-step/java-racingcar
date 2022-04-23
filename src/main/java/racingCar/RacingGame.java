package racingCar;

public class RacingGame {

    public void startGame(){
        InputView inputView = new InputView();
        int numberOfCar = inputView.numberOfCar();
        int numberOfGame = inputView.numberOfGame();

        Cars cars = new Cars(numberOfCar);

        ResultView resultView = new ResultView();

        System.out.println("\n실행 결과");
        while(numberOfGame>0){
            resultView.resultOfCars(cars);
            numberOfGame--;
        }
    }
}
