package domain;

import exception.NotValidNameException;

public class Car {

    private String name;
    private int currentLocation;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int currentLocation) {
        this.name = name;
        this.currentLocation = currentLocation;
    }

    public static void carNameValidation (String name) {
        if (name.length() > 5) {
            throw new NotValidNameException("자동차의 이름은 5자를 넘을 수 없습니다.");
        }
    }

    // public boolean move() {
    //
    // }

}
