import core.CarName;
import core.RaceModel;
import core.Winners;
import utils.AnnouncementPrinter;
import utils.CustomScanner;
import utils.RandomNumberGenerator;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        CustomScanner customScanner = CustomScanner.create(System.in);
        AnnouncementPrinter.printCarNameInputAnnouncement();
        List<CarName> carNames = customScanner.scanValidCarNames();
        RaceModel raceModel = RaceModel.initialize(carNames, customScanner.scanMoveCount());
        raceModel.moveCarsRandomlyMoveCountTimes(new RandomNumberGenerator());
        AnnouncementPrinter.printMoveResult(raceModel.getCars(), raceModel.getMoveCount());
        Winners winners = Winners.decideWinners(raceModel.getCars());
        AnnouncementPrinter.announceWinners(winners);
    }
}
