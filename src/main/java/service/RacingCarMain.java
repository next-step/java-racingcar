package service;

import java.util.List;
import view.RacingInputCarView;

public class RacingCarMain {

    public static void main(String[] args) {
        while (true) {
            List<String> carNames = RacingInputCarView.getCarNames();
            int targetDistance = RacingInputCarView.getTargetDistance();

            RacingCarService racingCarService = new RacingCarService();
            racingCarService.startRacing(carNames, targetDistance);
        }
    }

}
