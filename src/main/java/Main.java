

import view.InputView;
import view.ResultView;
import domain.Racing;

public class Main {

    public static void main(String[] args) {
        Racing racing =  InputView.input();

        ResultView resultView = new ResultView();
        resultView.doRaceAndPrintResult(racing);
    }
}
