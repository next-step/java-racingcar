package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {

    public void nameCheck(String carName) {
        String carNameArr[] = carName.split(",");

        for(int i = 0; i < carNameArr.length; i++){
            if (carNameArr[i].length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 5자 이상입니다");
            }
        }
    }

    public String[] carStringtoArray(String carName){
        String[] carNameArr = carName.split(",");

        for (int i = 0; i < carNameArr.length; i++) {
            carNameArr[i] += " : ";
        }

        return carNameArr;
    }

    public String moveOrNot(int number) {
        if (number>= 4) {
            return "-";
        }
        return "";
    }

    public List<String> selectWinner(String[] carNameArr) {
        List<String> winnerList = new ArrayList<String>();
        int maxlenth = 0;

        for (int i = 0; i < carNameArr.length; i++) {
            if (carNameArr[i].substring(carNameArr[i].indexOf(":") + 2, carNameArr[i].length()).length() >
                    maxlenth) {
                maxlenth = carNameArr[i].substring(carNameArr[i].indexOf(":") + 2, carNameArr[i].length()).length();
            }
        }

        for (int i = 0; i < carNameArr.length; i++) {
            if (maxlenth == carNameArr[i].substring(carNameArr[i].indexOf(":") + 2, carNameArr[i].length()).length()) {
                winnerList.add(carNameArr[i]);
            }
        }

        return winnerList;
    }

}
