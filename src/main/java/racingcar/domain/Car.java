package racingcar.domain;

import java.util.Objects;

public class Car {

    final private String car;
    private int location;

    public Car(String car){
        this.car = car;
        this.location = 1;
    }

    public String getCar(){
        return car;
    }

    public int getLocation(){
        return location;
    }

    public void moveLocation(){
        this.location = location + 1;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car1 = (Car) obj;
        return location == car1.getLocation() &&
                Objects.equals(car, car1.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, location);
    }
}
