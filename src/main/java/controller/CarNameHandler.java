package controller;

public class CarNameHandler {

    public String[] splitCarNames(String carNames) {
        return carNames.split(",");
    }

    public void checkCarNames(String[] carNames) {
        for (String carName : carNames) {
            checkEachCarName(carName);
        }
    }

    private void checkEachCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
    }
}
