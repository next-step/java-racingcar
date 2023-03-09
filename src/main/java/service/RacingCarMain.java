package service;

import java.util.List;
import view.RacingCarView;

public class RacingCarMain {

    public static void main(String[] args) {
        while (true) {
            List<String> carNames = RacingCarView.getCarNames();
            int targetDistance = RacingCarView.getTargetDistance();

            RacingCarService racingCarService = new RacingCarService();
            racingCarService.startRacing(carNames, targetDistance);
        }
    }

}
