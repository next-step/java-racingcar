package step3;

import step3.object.Car;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class CarRaceController {

    CarRaceService carRaceService;

    InputView inputView;

    ResultView resultView;

    public CarRaceController() {
        this.carRaceService = new CarRaceService();
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void start(){
        inputData();

        createCarList(inputView.getCarCount());

        playGame(inputView.getRacingCount());
    }

    public void inputData() {
        carRaceService.inputData(inputView);
    }

    public void createCarList(int carCount){
        carRaceService.createCarList(carCount);
    }

    public void playGame(int racingCount) {
        carRaceService.playGame(racingCount , resultView);
    }

    public List<Car> getCarList(){
        return carRaceService.getCarList();
    }


}
