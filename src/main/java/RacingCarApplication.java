import racingCar.domain.RacingManager;
import racingCar.ui.InputService;
import racingCar.ui.PrintService;

public class RacingCarApplication {

    public static void main(String[] args) {
        //pobi,crong,honux

        RacingManager racingManager = new RacingManager(
            InputService.getCarNameString().split(","), InputService.getTryCount()
        );
        PrintService.printResultMessage();

        for(int i = 0 ; i< racingManager.getTryCount() ; i++){
            racingManager.doOneLap();
            PrintService.printCurrentDrivenDistanceWithName(racingManager.getCars());
        }

        PrintService.printWinners(racingManager.getWinner());
    }
}
