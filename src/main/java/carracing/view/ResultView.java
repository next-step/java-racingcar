package carracing.view;

import carracing.CarRacing;
import carracing.RacingUtils;
import carracing.service.CarRacingService;
import java.util.Map;

public class ResultView {

    private CarRacing carRacing;

    public ResultView(CarRacing carRacing) {
        this.carRacing = carRacing;
    }

    public void execute() throws InterruptedException {
        CarRacingService carRacingService = new CarRacingService(carRacing);

        for (int i = 0; i < carRacing.getMovementQuantity(); i++) {
            Thread.sleep(RacingUtils.TIMER);
            this.viewRacing(carRacingService.gameStart());
        }
    }

    public void viewRacing(CarRacing carRacing) {
        Map<Integer, String> cars = carRacing.getCars();
        for (int key : cars.keySet()) {
            System.out.println(cars.get(key));
        }
        System.out.println();
    }
}
