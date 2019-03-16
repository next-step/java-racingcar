package domain;

import lombok.Getter;

public class Car {
    @Getter
    private String name;

    @Getter
    private Integer mileage;

    public Car(String name) {
        this.name = name;
        this.mileage = 0;
    }

    public Car(String name, Integer mileage) {
        this.name = name;
        this.mileage = mileage;
    }

    public void move(Rule rule){
        if(rule.canPass()){
            mileage++;
        }
    }
}
