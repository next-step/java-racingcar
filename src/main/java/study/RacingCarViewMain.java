package study;

import java.util.HashMap;
import java.util.Map;

public class RacingCarViewMain {

    public static void main(String[] args) {

        Map<String,String> inputValue = new HashMap<String,String>();

        Map<String,RacingCar> carMapList = new HashMap<String,RacingCar>();


        inputValue = InputView.input();

        carMapList = RacingCarGame.creatCar(inputValue.get("carValue"),inputValue.get("loopValue"));

        ResultView.result(carMapList);


    }
}
