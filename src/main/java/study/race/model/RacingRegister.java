package study.race.model;

import study.race.view.ReceiveInputValue;

public class RacingRegister {

    private final int CAR_NAME_LENGTH_LIMIT = 5;

    public Cars register(String carName) {
        String[] carNameList = carName.split(",");
        carNameList = checkCarNameValid(carNameList);
        return this.carRegister(carNameList);
    }

    private String[] checkCarNameValid(String[] names) {
        for (int i = 0; i < names.length; i++) {
            names[i] = getValidCarName(names[i]);
        }
        return names;
    }

    private String getValidCarName(String name) {
        if (name.length() > CAR_NAME_LENGTH_LIMIT) {
            return name.substring(0, 5);
        }
        return name;
    }

    private Cars carRegister(String[] carNameList) {
        Cars cars = new Cars();
        for (int i = 0; i < carNameList.length; i++) {
            cars.addCar(carNameList[i]);
        }
        return cars;
    }
}
