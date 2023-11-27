package study.race.model;

import study.race.view.ReceiveInputValue;

public class RacingRegister {

    public Cars register(String carName) {
        return carRegister(carName.split(","));
    }

    private Cars carRegister(String[] carNameList) {
        Cars cars = new Cars();
        for (String carName : carNameList) {
            cars.addCar(carName);
        }
        return cars;
    }
}
