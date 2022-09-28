package domain;

import exception.NotValidNameException;

public class Car {

    private String name;
    private int currentLocation;

    public Car() {
    }

    public Car(String name) {
        this.name = carNameValidation(name);
        this.currentLocation = 0;
    }

    public Car(String name, int currentLocation) {
        this.name = name;
        this.currentLocation = currentLocation;
    }

    public static String carNameValidation(String name) {
        if (name.length() > 5) {
            throw new NotValidNameException("자동차의 이름은 5자를 넘을 수 없습니다.");
        }
        return name;
    }

    public void move(boolean isMove) {
        if (isMove) {
            currentLocation += 1;
        }
    }

    public static Car createCar(String carName) {
        return new Car(carName);
    }

    public String getName() {
        return name;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

}
