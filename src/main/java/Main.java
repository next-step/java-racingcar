

import ui.InputView;
import ui.ResultView;
import model.Racing;

public class Main {

    public static void main(String[] args) {
        Racing racing =  InputView.input();
        ResultView.doRaceAndPrintResult(racing);
    }
}
