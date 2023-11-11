package study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static study.RacingCarGame.checkValue;


public class RacingCarViewMain {

    public static void main(String[] args) {

        ArrayList<RacingCar> carMapList = new ArrayList<RacingCar>();

        int carNum = checkValue(InputView.inputCarValue());
        int stepNum = checkValue(InputView.inputStepValue());

        String[] carNameList = InputView.inputCarName().split(",");

        carMapList = RacingCarGame.creatCar(carNum,carNameList,stepNum);

        ResultView.result(carMapList, stepNum);

    }
}
