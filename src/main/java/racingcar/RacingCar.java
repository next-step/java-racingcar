package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//enum Order {
//    GO("-"),
//    STOP("");
//
//    private String car_state;
//
//    Order(String car_state) {
//
//        this.car_state = car_state;
//    }
//}

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


}
