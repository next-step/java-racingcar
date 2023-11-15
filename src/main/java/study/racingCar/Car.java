package study.racingCar;

import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.Random;

public class Car {

    private Position position;

    public Car() {
        this(0);
    }

    public Car(int num){
        this.position =  new Position(num);
    }

    public Position currentPosition(){
        return position;
    }

    public void move(int num){
        this.position = this.position.increase(num);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
