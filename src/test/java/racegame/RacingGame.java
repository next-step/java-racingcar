package racegame;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RacingGame {

    @Test
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

    @Test
    int randomNumber() {
        int randomNummer = (int) (Math.random() * 10);
        return randomNummer;
    }

    @Test
    ArrayList<Map<String, Object>> racingGoing(ArrayList<Map<String, Object>> carList) {
        for (int i = 0; i < carList.size(); i++) {
            int random = randomNumber();
            if (random > 4) {
                carList.get(i).put("goStep", Integer.parseInt(carList.get(i).get("goStep").toString()) + 1);
            }
            checkPrint(carList.get(i));
        }

        return carList;

    }

    @Test
    void checkPrint(Map<String, Object> car) {
        int goStep = Integer.parseInt(car.get("goStep").toString());
        String goString = "";
        for (int i = 0; i < goStep; i++) {
            goString += "-";
        }
        System.out.println(car.get("carName") + ":" + goString);
    }

}
