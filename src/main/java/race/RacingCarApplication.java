package race;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import race.contorller.RacingGame;
import race.domain.Car;
import race.domain.Cars;
import race.view.InputView;
import race.view.ResultView;
import utils.StringUtils;
import utils.number.NumberGenerator;
import utils.number.RandomNumberGenerator;

public class RacingCarApplication {

    public static void main(String[] args) {
        RacingGame.run();
    }
}
