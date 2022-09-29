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

    public Car move(Car car, boolean isMove) {
        int isGo = car.getCurrentLocation();
        if (isMove) {
            return Car.of(car.getName(), isGo + 1);
        }
        return this;
    }

    public static Car createCar(String carName) {
        return new Car(carName);
    }

    public static Car of (String name, int currentLocation) {
        return new Car(name, currentLocation);
    }

    public String getName() {
        return name;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Car car) {
        this.currentLocation += car.getCurrentLocation();
    }

}
