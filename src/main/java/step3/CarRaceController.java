package step3;

import step3.domain.Car;
import step3.domain.Cars;
import step3.exception.CarRaceCheckInputException;
import step3.view.InputView;
import step3.view.ResultView;

public class CarRaceController {

    Cars cars;

    InputView inputView;

    ResultView resultView;

    public CarRaceController(Cars cars, InputView inputView) {
        this.cars = cars;
        this.inputView = inputView;
        this.resultView = new ResultView();
    }
    public CarRaceController() {
        this.cars = new Cars();
        this.resultView = new ResultView();
    }

    public void start(){

        inputView.inputData();

        cars.createCarList(inputView.getCarCount());

        playGame();

    }

    public void playGame() {
        if(inputView.validateRacing()){
            throw new CarRaceCheckInputException("시도할 회수가 유효하지 않습니다. 입력값 : %d".replace("%d",Integer.toString(inputView.getRacingCount())));
        }

        while(inputView.isRacing()){
            cars.move();

            displayMove();

            inputView.reduceRacing();
        }
    }

    private void displayMove() {
        for(Car car : cars.getCarList()){
            resultView.renderDrive(car.getGoCount());
        }
        System.out.println();
    }

}
