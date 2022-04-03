import core.Cars;
import core.Winners;
import utils.AnnouncementPrinter;
import utils.RaceProcessor;

public class RacingCarApplication {
    public static void main(String[] args) {
        AnnouncementPrinter.printCarNameInputAnnouncement();
        Cars cars = RaceProcessor.createValidCars();
        int moveCount = RaceProcessor.determineMoveCountFromInput();
        RaceProcessor.moveCarsRandomlyMoveCountTimes(cars, moveCount);
        AnnouncementPrinter.printMoveResult(cars, moveCount);
        Winners winners = Winners.decideWinners(cars);
        AnnouncementPrinter.announceWinners(winners);
    }
}
