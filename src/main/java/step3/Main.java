package step3;

import step3.model.Race;
import step3.view.InputView;
import step3.view.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.prepareRace();
        Race race = new Race(inputView.getCarNumbers(), inputView.getTryNumbers());
        ResultView resultView = new ResultView(race);
        resultView.showRace();
    }

}
