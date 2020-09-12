package mission1.step4.controller;

import mission1.step4.CarRace;
import mission1.step4.view.InputView;
import mission1.step4.view.RenderView;
import java.util.Arrays;

public class CarRaceController {
    public static void run() {
        InputView.run();

        CarRace carRace = CarRace.participate(Arrays.asList(InputView.carNameList.split(",")));

        System.out.println("실행결과");

        RenderView.showCarProgress(carRace.start(InputView.execNum));

        RenderView.showRaceWinner(carRace.getWinningCars());
    }
}


