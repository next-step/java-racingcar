import racingCar.domain.RacingManager;
import racingCar.ui.InputService;

public class RacingCarApplication {

    public static void main(String[] args) {

        RacingManager racingManager = new RacingManager(
            InputService.getNumberOfCar(), InputService.getTryCount()
        );
        racingManager.generateCars();
        racingManager.doFullRace();
    }
}
