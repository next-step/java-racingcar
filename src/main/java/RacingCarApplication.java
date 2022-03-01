import core.Cars;
import utils.AnnouncementPrinter;
import utils.RaceProcessor;

public class RacingCarApplication {
    public static void main(String[] args) {
        Cars cars = RaceProcessor.createValidCars();
        int moveCount = RaceProcessor.determineMoveCountFromInput();
        RaceProcessor.moveCarsRandomly(cars, moveCount);
        AnnouncementPrinter.announceWinners(cars);
    }
}
