package racingcar;

public class RacingCar {

    public void nameCheck(String carName) {
        String carNameArr[] = carName.split(",");

        for(int i = 0; i < carNameArr.length; i++){
            if (carNameArr[i].length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 5자 이상입니다");
            }
        }
    }
}
