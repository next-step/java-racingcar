package domain;

import utils.StringUtils;

public class CarName {

    private final String name;

    public CarName(String name) {
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
