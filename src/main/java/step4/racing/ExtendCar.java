package step4.racing;

import racing.SimpleCar;

public class ExtendCar extends SimpleCar {

    private String name;

    public ExtendCar(String name) {
        this.name = normalizeName(name);
    }

    private String normalizeName(String name) {
        return name.length() >= 5 ? name.substring(0, 5) : name;
    }

    public String name() {
        return name;
    }

}
