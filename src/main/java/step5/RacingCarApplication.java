package step5;

import step5.domain.RacingInformation;
import step5.domain.Stage;
import step5.view.InputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingInformation racingInformation = InputView.requestInput();
        Stage stage = new Stage(racingInformation);

        RacingCarService racingCarService = new RacingCarService(racingInformation, stage);
        racingCarService.startRacing();
    }

}
