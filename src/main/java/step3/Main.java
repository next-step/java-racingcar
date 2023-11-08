package step3;

import step3.view.InputView;
import step3.view.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.prepareRace();
        ResultView resultView = new ResultView(inputView.getCarNumbers(), inputView.getTryNumbers());
        resultView.showRace();
    }

}
