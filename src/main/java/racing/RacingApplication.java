package racing;

import dto.Response;
import racing.ui.RacingController;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingApplication {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        RacingController racingController = appConfig.racingController();
        Response response = racingController.play(InputView.input());
        ResultView.print(response);
    }
}
