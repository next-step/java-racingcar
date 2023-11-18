package study.racingCar;

import java.util.Objects;

public class Car {

    private final String name;
    private Position position;

    public Car() {
        this("");
    }

    public Car(String name) {
        this.name = name;
        this.position = new Position();
    }

    public void move(int num){
        this.position = position.increase(num);
    }

    public Car getTheWinner(Car car){
        if (position.isBiggerThan(car.position)){
            return this;
        }
        return car;
    }

    public void printName(){
        System.out.print(this.name);
    }

    public void printPosition(){
        this.position.print();
    }

    public boolean isSamePosition(Car car){
        return position.equals(car.position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name);

    }
}
