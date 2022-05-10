import core.*;
import utils.AnnouncementPrinter;
import utils.CustomScanner;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        CustomScanner customScanner = CustomScanner.create(System.in);
        AnnouncementPrinter.printCarNameInputAnnouncement();
        List<CarName> carNames = customScanner.scanValidCarNames();
        int moveCount = customScanner.scanMoveCount();
        Cars cars = Cars.fromCarNames(carNames);
        RacingGame racingGame = new RacingGame(new RandomPowerSupply());
        PositionBoard positionBoard = racingGame.play(cars, moveCount);
        AnnouncementPrinter.printMoveResult(cars, positionBoard, moveCount);
        Winners winners = Winners.decideWinners(positionBoard);
        AnnouncementPrinter.announceWinners(winners);
    }
}
