package racingcar;

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

    public void nameCheck(String input) {

        if (input.length() > 5) {

            throw new IllegalArgumentException("자동차 이름이 5자 이상입니다");
        }
    }

    public String condition() {

        Random random = new Random();

        if (random.nextInt(9) >= 4) {

            return "-";
        }
        return "";
    }
}
