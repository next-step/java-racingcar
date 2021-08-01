import racingCar.domain.RacingManager;
import racingCar.ui.InputService;

public class RacingCarApplication {

    public static void main(String[] args) {
        //pobi,crong,honux

        RacingManager racingManager = new RacingManager(
            InputService.getCarNameString().split(","), InputService.getTryCount()
        );

        racingManager.doFullRace();
    }
}
