package study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RacingCarViewMain {

    public static void main(String[] args) {

        ArrayList<RacingCar> carMapList = new ArrayList<RacingCar>();

        carMapList = RacingCarGame.creatCar(InputView.inputCarValue(),InputView.inputCarName(),InputView.inputStepValue());

        ResultView.result(carMapList);

    }
}
