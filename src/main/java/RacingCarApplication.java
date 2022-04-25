import core.CarName;
import core.Cars;
import core.RacingGame;
import core.Winners;
import utils.AnnouncementPrinter;
import utils.CustomScanner;
import core.RandomPowerSupply;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        CustomScanner customScanner = CustomScanner.create(System.in);
        AnnouncementPrinter.printCarNameInputAnnouncement();
        List<CarName> carNames = customScanner.scanValidCarNames();
        int moveCount = customScanner.scanMoveCount();
        Cars cars = Cars.fromCarNames(carNames);
        RacingGame racingGame = new RacingGame(new RandomPowerSupply());
        Cars resultCars = racingGame.play(cars, moveCount);
        AnnouncementPrinter.printMoveResult(resultCars, moveCount);
        Winners winners = Winners.decideWinners(resultCars);
        AnnouncementPrinter.announceWinners(winners);
    }
}
