package racing.main;

import racing.domain.Competition;
import racing.ui.InputView;
import racing.ui.ResultView;

public class Controller {
    public static void main(String[] args) {
        Competition competition = InputView.input();
        ResultView.print(competition);
    }
}
