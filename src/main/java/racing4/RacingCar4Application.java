package racing4;

import racing4.application.Race4Service;
import racing4.domain.Race4Car;
import racing4.domain.Race4Command;
import racing4.view.InputView;

public class RacingCar4Application {
    public static void main(String[] args) {
        Race4Command race4Command = InputView.input();
        Race4Service race4Service = new Race4Service(Race4Car.makeCarsBy(race4Command.getCarNames()),
                                                     race4Command.getTryCount());
        race4Service.playAndDisplay();
    }
}
