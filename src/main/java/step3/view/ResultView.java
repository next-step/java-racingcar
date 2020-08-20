package step3.view;

import step3.operation.Operation;

public class ResultView {

    public void resultView(int numOfAtp, int numOfCars){

        Operation operation = new Operation();
        operation.gameStart(numOfAtp, numOfCars);

    }
}
