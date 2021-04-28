package racingcar;

enum Order {
    GO("-"),
    STOP("");

    private String car_state;

    Order(String car_state) {

        this.car_state = car_state;
    }

    public String getCar_state() {

        return car_state;
    }
}

public class RacingCar {

    public void nameCheck(String input) {

        if (input.length() > 5) {

            throw new IllegalArgumentException("자동차 이름이 5자 이상입니다");
        }
    }
}
