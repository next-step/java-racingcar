

import UI.InputView;
import UI.ResultView;
import model.Racing;

public class Main {

    public static void main(String[] args) {
        Racing racing =  InputView.input();
        ResultView.doRaceAndPrintResult(racing);
    }
}
