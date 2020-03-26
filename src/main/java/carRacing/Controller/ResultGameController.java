package carRacing.Controller;


import carRacing.Domain.Vehicle;
import carRacing.view.ResultView;

import java.util.List;

public class ResultGameController {

    private  ResultView resultView;

    private ResultGameController() {
        resultView = new ResultView();
        resultView.showResult();
    }

    public static ResultGameController init() {
        return new ResultGameController();
    }

    public void showGameState(List<Vehicle> vehicles) {
        resultView.showGameState(vehicles);
    }
}
