package step3.view;

import step3.controller.CarController;

import java.util.HashMap;
import java.util.List;

public class ResultView {

    InputView inputView = new InputView();
    CarController carController = new CarController(inputView.inputCar(), inputView.inputAttempt());

    public void print() {
        HashMap<Integer, List<String>> result = carController.getEachCarAdvance();
        for(int i = 0 ; i < result.size(); i++) {
            for(int j = 0; j < result.get(i).size(); j++) {
                System.out.println(result.get(i).get(j));
            }
            System.out.println("");
        }
    }
}
