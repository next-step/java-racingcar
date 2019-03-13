package domain;

public class Car {
    private String name;
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

    public String getName(){
        return name;
    }

    public Integer getMileage(){
        return mileage;
    }
}
