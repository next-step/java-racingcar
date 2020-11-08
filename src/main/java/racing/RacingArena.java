package racing;

import racing.view.InputView;
import racing.view.ResultView;

public class RacingArena {
    public static void main(String[] args) {
        int vehicleCount = InputView.getVehicleCount();
        int maxCheckPoint = InputView.getMaxCheckPoint();

        CarRacing carRacing = new CarRacing(vehicleCount,maxCheckPoint);
        carRacing.start();

        ResultView.viewRaceResult(carRacing.getRaceResults());
    }
}
