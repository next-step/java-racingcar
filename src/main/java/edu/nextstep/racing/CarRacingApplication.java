package edu.nextstep.racing;

import edu.nextstep.racing.service.CarRacingService;
import edu.nextstep.racing.utils.SplitUtils;
import edu.nextstep.racing.view.InputView;

import java.util.List;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-22 15:03
 */
public class CarRacingApplication {

    public static void main(String[] args) {
        CarRacingApplication app = new CarRacingApplication();
        app.run();
    }

    public void run() {
        String carNames = InputView.inputCars();
        int round = InputView.inputRound();

        List<String> names = SplitUtils.commaSplit(carNames);
        CarRacingService service = new CarRacingService(names, round);

        service.raceStart();
    }
}
