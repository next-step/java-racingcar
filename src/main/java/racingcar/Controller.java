package racingcar;

public class Controller {
    public void racingGame(){
        InputView inputView = new InputView();

        int numOfCar = inputView.numberOfCar();
        int numOfTry = inputView.ChanceOfTry();
    }
}
