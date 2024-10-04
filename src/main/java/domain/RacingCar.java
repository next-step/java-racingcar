package domain;

import util.Validator;

public class RacingCar {
    private int status;
    private String name;

    public RacingCar() {
        this.status = 0;
        this.name = "";
    }

    public RacingCar(String name) {
        if (!Validator.isValidCarNameLength(name)) {
            throw new IllegalArgumentException("자동차 이름은 5자 초괴되면 안됩니다. " + name);
        }
        this.status = 0;
        this.name = name;
    }

    public RacingCar(int status) {
        this.status = status;
        this.name = "";
    }

    public RacingCar(int status, String name) {
        if (!Validator.isValidCarNameLength(name)) {
            throw new IllegalArgumentException("자동차 이름은 5자 초괴되면 안됩니다. " + name);
        }
        this.status = status;
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public void move(int num) {
        if (num >= 4) {
            this.status++;
        }
    }
}
