package step4.racing;

import racing.SimpleCar;
import utils.StringUtils;

public class NameCar extends SimpleCar {

    private String name;

    public NameCar(String name) {
        this.name = normalizeName(name);
    }

    private String normalizeName(String name) {
        if (StringUtils.isEmpty(name)) {
            return "NoName";
        }

        if (name.length() < 5) {
            return name;
        }

        return name.substring(0, 5);
    }

    public String name() {
        return name;
    }

}
