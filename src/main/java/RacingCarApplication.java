import core.CarName;
import core.Cars;
import core.RaceModel;
import core.Winners;
import utils.AnnouncementPrinter;
import utils.CustomScanner;
import utils.RandomNumberGenerator;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        AnnouncementPrinter.printCarNameInputAnnouncement();
        List<CarName> carNames = CustomScanner.scanValidCarNames();
        RaceModel raceModel = new RaceModel();
        raceModel.setCars(Cars.fromCarNames(carNames));
        raceModel.setMoveCount(CustomScanner.scanMoveCount());
        raceModel.moveCarsRandomlyMoveCountTimes(new RandomNumberGenerator());
        AnnouncementPrinter.printMoveResult(raceModel.getCars(), raceModel.getMoveCount());
        Winners winners = Winners.decideWinners(raceModel.getCars());
        AnnouncementPrinter.announceWinners(winners);
    }
}
