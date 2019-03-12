package domain;

public class Car {
    private Integer mileage;

    public Car() {
        this.mileage = 0;
    }

    public void move(){
        mileage++;
    }

    public Integer getMileage(){
        return mileage;
    }
}
