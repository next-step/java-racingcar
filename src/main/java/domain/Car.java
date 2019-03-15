package domain;

import lombok.Getter;

public class Car {
    @Getter
    private String name;

    @Getter
    private Integer mileage;

    public Car() {
        this.mileage = 0;
    }

    public Car(String name) {
        this();
        this.name = name;
    }

    public void move(){
        mileage++;
    }
}
