package racingcar;

public class RacingCar {

    public void nameCheck(String carName) {
        String[] carNames = carName.split(",");
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 5자 이상입니다");
            }
        }
    }

    public String[] carStringtoArray(String carName) {
        String[] carNameArr = carName.split(",");
        for (int i = 0; i < carNameArr.length; i++) {
            carNameArr[i] += " : ";
        }
        return carNameArr;
    }

    public String moveOrNot(int number) {
        if (number >= 4) {
            return "-";
        }
        return "";
    }

}
