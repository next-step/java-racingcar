package study.race.model;

import study.race.view.ReceiveInputValue;

public class RacingRegister {

    private final int CAR_NAME_LENGTH_LIMIT = 5;

    private String[] carNameList;

    public Cars register(String carName) {
        this.carNameList = carName.split(",");
        checkCarNameValid(carNameList);
        return this.carRegister(carNameList);
    }

    private void checkCarNameValid(String[] names) {
        for (String name : names) {
            isOverLength(name);
        }
    }

    private void isOverLength(String name) {
        if (name.length() > CAR_NAME_LENGTH_LIMIT)
            throw new IllegalArgumentException("String length exceeds the allowed maximum(5).");
    }

    private Cars carRegister(String[] carNameList) {
        Cars cars = new Cars();
        for (String carName : carNameList) {
            cars.addCar(carName);
        }
        return cars;
    }
}
