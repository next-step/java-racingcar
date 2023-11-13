package study;

import study.domain.RacingCar;
import study.domain.RacingCarGame;
import study.view.InputView;
import study.view.ResultView;

import java.util.ArrayList;

import static study.domain.RacingCarGame.checkValue;


public class RacingCarViewMain {

    public static void main(String[] args) {

        ArrayList<RacingCar> carList = new ArrayList<RacingCar>();

        int carNum = checkValue(InputView.inputCarValue());
        int stepNum = checkValue(InputView.inputStepValue());

        String[] carNameList = InputView.inputCarName().split(",");

        carList = RacingCarGame.creatCar(carNum,carNameList,stepNum);

        ResultView.result(carList, stepNum);

    }
}
