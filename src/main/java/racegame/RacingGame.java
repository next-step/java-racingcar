package racegame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RacingGame {
    ArrayList<Map<String, Object>> racingSetting(String[] nameList) {
        ArrayList<Map<String, Object>> racingCarList = new ArrayList<>();
        for (int i = 0; i < nameList.length; i++) {

            Map<String, Object> racingCar = new HashMap<>();
            racingCar.put("carName", nameList[i].toString());
            racingCar.put("goStep", 0);

            racingCarList.add(racingCar);
        }

        return racingCarList;
    }

    int randomNumber() {
        int randomNummer = (int) (Math.random() * 10);
        return randomNummer;
    }

    ArrayList<Map<String, Object>> racingGoing(ArrayList<Map<String, Object>> carList) {
        for (Map<String , Object> car: carList) {
            goStepAdd(car);
        }
        return carList;
    }

    private void goStepAdd(Map<String, Object> car) {
        int random = randomNumber();
        if (random >= 4) {
            car.put("goStep", Integer.parseInt(car.get("goStep").toString()) + 1);
        }
        checkPrint(car);
    }

    void checkPrint(Map<String, Object> car) {
        int goStep = Integer.parseInt(car.get("goStep").toString());
        String goString = "";
        for (int i = 0; i < goStep; i++) {
            goString += "-";
        }
        System.out.println(car.get("carName") + ":" + goString);
    }

}
