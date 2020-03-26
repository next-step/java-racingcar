package carRacing.Controller;


import carRacing.Domain.Vehicles;
import carRacing.view.ResultView;


public class ResultGameController {

    private ResultView resultView;

    private ResultGameController() {
        resultView = new ResultView();
        resultView.showResult();
    }

    public static ResultGameController init() {
        return new ResultGameController();
    }

    public void showGameState(Vehicles vehicles) {
        resultView.showGameState(vehicles);
    }

    public void showWinner(Vehicles vehicles) {
        resultView.showWinner(vehicles);
    }
}
