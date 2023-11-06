package study;

import java.util.HashMap;
import java.util.Map;

public class RacingCarViewMain {

    public static void main(String[] args) {

        Map<String,RacingCar> carMapList = new HashMap<String,RacingCar>();

        carMapList = RacingCarGame.creatCar(InputView.inputCarValue(),InputView.inputStepValue());

        ResultView.result(carMapList);

    }
}
