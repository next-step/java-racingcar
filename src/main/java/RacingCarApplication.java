import racingCar.domain.RacingManager;
import racingCar.domain.StringUtils;
import racingCar.ui.InputService;

public class RacingCarApplication {

    public static void main(String[] args) {
        //pobi,crong,honux

        RacingManager racingManager = new RacingManager(
            StringUtils.namesSpliter(InputService.getCarNameString()), InputService.getTryCount()
        );

        racingManager.doFullRace();
    }
}
